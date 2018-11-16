package strava.acambieri.skatebuddy.services;

import io.swagger.client.ApiClient;
import io.swagger.client.api.ActivitiesApi;
import io.swagger.client.model.ActivityType;
import io.swagger.client.model.SummaryActivity;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import strava.acambieri.skatebuddy.model.Activity;
import strava.acambieri.skatebuddy.model.User;
import strava.acambieri.skatebuddy.model.stravaAuth.AuthorizationResponseBean;
import strava.acambieri.skatebuddy.model.stravaAuth.RefreshTokenExchangeBean;

import java.lang.reflect.Proxy;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class StravaConnectorService implements IStravaConnectorService {

    private static final Logger log = LoggerFactory.getLogger(StravaConnectorService.class);

    @Value("${clientId}")
    private String clientId;

    @Value("${clientSecret}")
    private String clientSecret;

    @Value("${callbackURL}")
    private String callbackURL;

    @Value("${strava.authToken.url}")
    private String stravaAuthTokenURL;

    @Autowired
    private BeanFactory beans;

   protected UserService getUserService(){
       if(this instanceof StravaConnectorServiceWeb){
            return beans.getBean(UserServiceWeb.class);
       }
       else{
           return beans.getBean(UserServiceBatch.class);
       }
   }

    @Override
    public List<Activity> getNewActivies(User user){
        ActivitiesApi api = getApiClient(user,ActivitiesApi.class);
        List<SummaryActivity> activityList = api.getLoggedInAthleteActivities(null,
                (int) (user.getStats().getLastImportedActivityDate() == null ? 0 : user.getStats().getLastImportedActivityDate().toEpochSecond(ZoneOffset.UTC)),
                null,100);
        List<Activity> result = new ArrayList<>(activityList.size());
        //Activies from strava are ordered by date descending, we return in ascending order
        activityList.forEach(act -> {
            if(act.getType().equals(ActivityType.INLINESKATE)){
                result.add(Activity.from(act));
            }
        });
        return result;
    }

/*    public void completeUserInfo(User user){
        AthletesApi api = getApiClient(user, AthletesApi.class);
        DetailedAthlete athlete = api.getLoggedInAthlete();
        user.setEmail(athlete.getEmail());
        user.setStravaId(athlete.getId());
    }*/


    private <T extends ApiClient.Api> T getApiClient(User user, Class<T> clazz){
        ApiClient api = new ApiClient("strava_oauth");
        api.setAccessToken(user.getAccessToken(),user.getTokenExpiresAt().toEpochMilli()-Instant.now().toEpochMilli());
        return api.buildClient(clazz);
    }

    @Override
    public void refreshToken(User user) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.ALL_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);
        RefreshTokenExchangeBean tokens = new RefreshTokenExchangeBean();
        tokens.setClient_id(clientId);
        tokens.setClient_secret(clientSecret);
        tokens.setRefresh_token(user.getRefreshToken());
        tokens.setGrant_type(GrantType.REFRESH_TOKEN.toString());
        HttpEntity<RefreshTokenExchangeBean> body = new HttpEntity<>(tokens,headers);
        AuthorizationResponseBean response = restTemplate.postForObject(stravaAuthTokenURL,body,AuthorizationResponseBean.class);
        user.setAccessToken(response.getAccess_token());
        user.setTokenExpiresAt(response.getExpires_at());
        user.setRefreshToken(response.getRefresh_token());
        getUserService().updateUser(user);
    }

    public IStravaConnectorService getService(){
        IStravaConnectorService proxiedService = (IStravaConnectorService) Proxy.newProxyInstance(
                StravaConnectorService.class.getClassLoader(),
                new Class[]{IStravaConnectorService.class},
                (proxy,method,args) -> {
                    User u = getUserFromArgs(args);
                    if(u != null && Instant.now().plus(1, ChronoUnit.HOURS).isAfter((u.getTokenExpiresAt()))){
                        refreshToken(u);
                        getUserService().updateUser(u);
                    }
                    return method.invoke(StravaConnectorService.this,args);
                }
        );
        return proxiedService;
    }




    private static User getUserFromArgs(Object[] args){
        for(Object o : args){
            if (o instanceof User){
                return (User) o;
            }
        }
        return null;
    }
}
