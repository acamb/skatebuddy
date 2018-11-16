package strava.acambieri.skatebuddy.services;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Qualifier("batch")
@Scope("batch")
public class SkateBuddyServiceBatch extends SkateBuddyService implements DisposableBean {

    @Autowired
    public SkateBuddyServiceBatch(@Qualifier("myFactory")
                                          SqlSessionFactory factory) {
        super(factory);
    }

    @Autowired
    public void setStravaConnectorService(@Qualifier("batch") IStravaConnectorService service){
        this.stravaConnectorService=service;
    }
}
