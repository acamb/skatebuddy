package strava.acambieri.skatebuddy.services;

import strava.acambieri.skatebuddy.model.Activity;
import strava.acambieri.skatebuddy.model.User;
import strava.acambieri.skatebuddy.model.stravaAuth.AuthorizationResponseBean;

import java.util.List;

public interface IStravaConnectorService {

    public List<Activity> getNewActivies(User user);

    public void refreshToken(User user);
}
