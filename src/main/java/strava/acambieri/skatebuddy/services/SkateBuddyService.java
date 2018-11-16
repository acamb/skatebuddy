package strava.acambieri.skatebuddy.services;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import strava.acambieri.skatebuddy.Utils;
import strava.acambieri.skatebuddy.mapper.SkateBuddyMapper;
import strava.acambieri.skatebuddy.model.*;
import strava.acambieri.skatebuddy.model.stravaAuth.AuthorizationResponseBean;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;


public class SkateBuddyService implements DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(SkateBuddyService.class);

    protected IStravaConnectorService stravaConnectorService;

    private SqlSession session;
    private SkateBuddyMapper mapper;


    public SkateBuddyService(
                                 SqlSessionFactory factory){
        this.session = factory.openSession();
        mapper = session.getMapper(SkateBuddyMapper.class);
    }



    public void addWheel(User user,Wheel wheel,boolean setAsActive){
        mapper.addWheel(user,wheel);
        if(setAsActive){
            mapper.setCurrentWheel(user,wheel);
        }
    }

    public void rotateWheels(User user){
        if(user.getStats().getCurrentWheel() != null){
            user.getStats().getCurrentWheel().setRotationCounter(user.getStats().getCurrentWheel().getRotationCounter()+1);
            mapper.rotateWheel(user.getStats().getCurrentWheel());
        }
    }

    public List<Wheel> getWheels(User user){
        return mapper.getWheels(user);
    }

    public List<Activity>  importNewActivities(User user,boolean batchMode){
        List<Activity> activities = stravaConnectorService.getNewActivies(user);
        AtomicBoolean b = new AtomicBoolean(false);
        activities.forEach(act -> {
            try {
                mapper.insertActivy(act,user.getStats().getCurrentWheel());
                user.getStats().setLastImportedActivityDate(act.getDate());
                mapper.updateStats(user);
                session.commit();
                b.set(true);
            }
            catch(PersistenceException ex){
                logger.error("Error imporing activity [ " + act.toString() + "] for user [ " + user.toString() + " ] : " + Utils.exceptionToString(ex));
                if(batchMode){
                    //TODO send email?
                }
                session.rollback();
            }
        });
        if(b.get()) {
            if (user.getStats().getCurrentWheel() != null) {
                //recalculate current wheel stats
                mapper.recalculateWheel(user.getStats().getCurrentWheel());
            }
            //recalculate avg and max values
            mapper.calculateAvgPerUser(user);
        }
        return activities;
    }

    public void recalculateStatsAndWheels(User user,Activity deletedActivity,Activity addedActivity){
        mapper.calculateAvgPerUser(user);
        if(deletedActivity != null){
            recalculateWheel(deletedActivity.getWheel());
        }
        if(addedActivity != null){
            recalculateWheel(addedActivity.getWheel());
        }

    }

    public void recalculateWheel(Wheel wheel){
        mapper.recalculateWheel(wheel);
    }

    public void updateStats(User u){
        mapper.updateStats(u);
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


    public void setCurrentWheel(User user, Wheel wheel) {
        mapper.setCurrentWheel(user,wheel);
    }

    public void deleteWheel(Long id) {
        mapper.disassociateWheel(id);
        mapper.deleteWheel(id);
    }

    public Wheel getCurrentWheel(User user) {
        return mapper.getCurrentWheel(user);
    }

    public List<Activity> getActivities(User user) {
        return mapper.getActivities(user);
    }

    public Activity getActivity(User user, long id) {
        return mapper.getActivity(user,id);
    }

    public void deleteActivity(User user, long id) {
        mapper.deleteActivity(user,id);
    }

    public void updateActivity(Activity activity) {
        mapper.updateActivity(activity);
    }
}
