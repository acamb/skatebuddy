package strava.acambieri.skatebuddy.services;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import strava.acambieri.skatebuddy.mapper.SkateBuddyMapper;
import strava.acambieri.skatebuddy.mapper.UserMapper;
import strava.acambieri.skatebuddy.model.Stats;
import strava.acambieri.skatebuddy.model.User;
import strava.acambieri.skatebuddy.model.stravaAuth.AuthorizationResponseBean;

import java.util.List;


public class UserService implements DisposableBean {

    private SqlSession session;
    private UserMapper mapper;


    public UserService( SqlSessionFactory factory){
        this.session = factory.openSession();
        mapper = session.getMapper(UserMapper.class);
    }

    public void rollback(){
        session.rollback();
    }

    public void commit(){
        session.commit();
    }

    @Override
    public void destroy() throws Exception {
        session.commit();
        session.close();
    }

    public User getUser(User user){
        User dbUser = getPrivateUser(user);
        if(dbUser.getAccessToken() != null && !dbUser.getAccessToken().isEmpty()){
            dbUser.setAccessToken("***");
            dbUser.setRefreshToken("***");
        }
        return dbUser;
    }

    public User getPrivateUser(User user){
        session.clearCache();
        User dbUser = mapper.getUser(user);
        if(dbUser == null){
            synchronized (UserService.class) {
                session.clearCache();
                dbUser = mapper.getUser(user);
                if(dbUser == null) {
                    createUser(user);
                    dbUser = mapper.getUser(user);
                    session.commit();
                }
            }
        }
        if(dbUser.getStats() == null){
            dbUser.setStats(new Stats());
        }
        return dbUser;
    }

    private void createUser(User user) {
        mapper.createUser(user);
        mapper.initStats(user);
    }

    public User updateUser(User user){
        mapper.updateUser(user);
        return getUser(user);
    }

    public List<User> getImportableUsers(){
        return mapper.getImportableUsers();
    }
}
