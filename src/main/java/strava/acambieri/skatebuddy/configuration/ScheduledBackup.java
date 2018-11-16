package strava.acambieri.skatebuddy.configuration;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import strava.acambieri.skatebuddy.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledBackup {

    @Value("${backup.dir}")
    String backupDir;

    @Autowired
    private @Qualifier("myFactory") SqlSessionFactory factory;

    private static Logger log = LoggerFactory.getLogger(ScheduledBackup.class);
    private DateFormat df = new SimpleDateFormat("yyyyMMddhhmm");

    @Scheduled(cron="${cron.backup}")
    public void backup(){
        log.info("Starting backup");
        SqlSession session = factory.openSession();
        try {
            PreparedStatement ps = session.getConnection().prepareStatement("SCRIPT TO '" + backupDir + "/backup-" + df.format(new Date()) + "'");
            ps.execute();
        }
        catch(SQLException ex){
            log.error("Error while executing backup: " + Utils.exceptionToString(ex));
        }
        finally {
            try {
                session.close();
            }
            catch(Exception ex){

            }
        }
        log.info("backup finished.");
    }
}
