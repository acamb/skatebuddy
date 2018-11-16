package strava.acambieri.skatebuddy.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import strava.acambieri.skatebuddy.Utils;
import strava.acambieri.skatebuddy.configuration.scopes.BatchScope;
import strava.acambieri.skatebuddy.model.User;
import strava.acambieri.skatebuddy.services.SkateBuddyService;
import strava.acambieri.skatebuddy.services.SkateBuddyServiceBatch;
import strava.acambieri.skatebuddy.services.UserService;
import strava.acambieri.skatebuddy.services.UserServiceBatch;

import java.util.List;

@Component
public class ScheduledImport {

    private static Logger log = LoggerFactory.getLogger(ScheduledImport.class);

    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private ConfigurableListableBeanFactory context;

    @Scheduled(cron="${cron.import}")
    public void importNewActivities(){
        UserService userService = beanFactory.getBean(UserServiceBatch.class);
        SkateBuddyService service = beanFactory.getBean(SkateBuddyServiceBatch.class);
        log.info("Starting scheduled import");
        List<User> importableUsers = userService.getImportableUsers();
        importableUsers.forEach( user -> {
            try {
                service.importNewActivities(user, true);
                service.commit();
            }
            catch(Exception ex){
                log.error("Error while importing activities for user [ " + user.toString() + " ] : " + Utils.exceptionToString(ex));
                service.rollback();
            }
        });
        ((BatchScope)context.getRegisteredScope("batch")).clear();
        log.info("Imported activities for " + importableUsers.size() + " users");
    }
}
