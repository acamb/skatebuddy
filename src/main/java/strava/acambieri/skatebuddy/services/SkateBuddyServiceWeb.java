package strava.acambieri.skatebuddy.services;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Primary
@Scope(value="request", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class SkateBuddyServiceWeb extends SkateBuddyService implements DisposableBean {

    @Autowired
    public SkateBuddyServiceWeb(@Qualifier("myFactory")
                                            SqlSessionFactory factory){
        super(factory);
    }

    @Autowired
    public void setStravaConnectorService(IStravaConnectorService service){
        this.stravaConnectorService=service;
    }


}
