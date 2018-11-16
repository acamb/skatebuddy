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
public class UserServiceWeb extends UserService implements DisposableBean {
    @Autowired
    public UserServiceWeb(@Qualifier("myFactory")
                                  SqlSessionFactory factory){
        super(factory);
    }
}
