package strava.acambieri.skatebuddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SkatebuddyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkatebuddyApplication.class, args);
	}
}
