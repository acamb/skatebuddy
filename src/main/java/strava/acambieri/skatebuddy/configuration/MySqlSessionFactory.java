package strava.acambieri.skatebuddy.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import strava.acambieri.skatebuddy.Utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

/**
 * @author andrea AC
 *         Date: 22/11/2016
 */

@Configuration
public class MySqlSessionFactory {

    private SqlSessionFactory factory;

    public MySqlSessionFactory(){
        Reader reader = null;
        try {
            reader = new InputStreamReader(new ClassPathResource("myBatis.xml").getInputStream());
        } catch (IOException e) {
            throw new RuntimeException("Error reading/accessing myBatis.xml: " + Utils.exceptionToString(e));
        }
        factory = new SqlSessionFactoryBuilder().build( reader );
    }



    @Bean
    @Qualifier("myFactory")
    public SqlSessionFactory getSession(){
        return factory;
    }
}
