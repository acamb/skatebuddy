package strava.acambieri.skatebuddy.controller;

import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.cryptacular.util.CertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import strava.acambieri.skatebuddy.model.SessionBean;
import strava.acambieri.skatebuddy.model.Stats;
import strava.acambieri.skatebuddy.model.User;
import strava.acambieri.skatebuddy.model.stravaAuth.AuthorizationResponseBean;
import strava.acambieri.skatebuddy.model.stravaAuth.AuthorizationTokenExchangeBean;
import strava.acambieri.skatebuddy.services.IStravaConnectorService;
import strava.acambieri.skatebuddy.services.SkateBuddyService;
import strava.acambieri.skatebuddy.services.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.cert.X509Certificate;
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Value("${clientId}")
    private String clientId;

    @Value("${clientSecret}")
    private String clientSecret;

    @Value("${callbackURL}")
    private String callbackURL;

    @Value("${client.home}")
    private String clientHome;

    @Autowired
    private SessionBean sessionBean;

    @Autowired
    private SkateBuddyService service;

    @Autowired
    private UserService userService;

    @Value("${strava.authorize.url}")
    private String stravaAuthorizeURL;

    @Value("${strava.authToken.url}")
    private String stravaAuthTokenURL;

    @Value("${environment}")
    private String environment;

    @GetMapping("/get")
    public User authenticate(@Value("#{request.getAttribute('javax.servlet.request.X509Certificate')}") X509Certificate x509){
        if(x509 == null && "test".equals(environment)){
            sessionBean.getUser().setUsername("andrea");
        }
        else {
            sessionBean.getUser().setUsername(CertUtil.subjectCN(x509));
        }
        sessionBean.setUser(userService.getPrivateUser(sessionBean.getUser()));
        return userService.getUser(sessionBean.getUser());
    }

    @GetMapping("/authorize")
    public void login(HttpServletResponse response) throws IOException {
        response.sendRedirect(
                stravaAuthorizeURL +
                        "?client_id=" + clientId +
                        "&redirect_uri="+callbackURL +
                        "&response_type=code" +
                        "&approval_prompt=auto" +
                        "&scope=read_all,activity:read_all,activity:read" +
                        "&state=login"
        );
    }

    @GetMapping("/callback")
    public void callback(@RequestParam String code,
                         @RequestParam String scope,
                         @RequestParam(required = false   ) String error,
                         @RequestParam(required = false) String state,
                         HttpServletResponse response
    ) throws IOException{
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.ALL_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);
        AuthorizationTokenExchangeBean tokens = new AuthorizationTokenExchangeBean();
        tokens.setClient_id(clientId);
        tokens.setClient_secret(clientSecret);
        tokens.setCode(code);
        tokens.setGrant_type(GrantType.AUTHORIZATION_CODE.toString());
        HttpEntity<AuthorizationTokenExchangeBean> body = new HttpEntity<>(tokens,headers);
        AuthorizationResponseBean resp=restTemplate.postForObject(stravaAuthTokenURL,body,AuthorizationResponseBean.class);
        sessionBean.getUser().setAccessToken(resp.getAccess_token());
        sessionBean.getUser().setTokenExpiresAt(resp.getExpires_at());
        sessionBean.getUser().setRefreshToken(resp.getRefresh_token());
        sessionBean.getUser().setStravaId(resp.getAthlete().getId());
        userService.updateUser(sessionBean.getUser());
        response.sendRedirect(clientHome);
    }

    @PutMapping("/stats/update")
    public Stats updateStats(@RequestBody Stats stats){
        sessionBean.getUser().setStats(stats);
        service.updateStats(sessionBean.getUser());
        return sessionBean.getUser().getStats();
    }

    @PutMapping("/stats/calculate")
    public Stats updateStats(){
        service.updateStats(sessionBean.getUser());
        return sessionBean.getUser().getStats();
    }
}
