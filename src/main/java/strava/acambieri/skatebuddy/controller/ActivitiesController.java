package strava.acambieri.skatebuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import strava.acambieri.skatebuddy.model.Activity;
import strava.acambieri.skatebuddy.model.RestResponse;
import strava.acambieri.skatebuddy.model.SessionBean;
import strava.acambieri.skatebuddy.model.Wheel;
import strava.acambieri.skatebuddy.services.SkateBuddyService;
import strava.acambieri.skatebuddy.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivitiesController {


    @Autowired
    private SessionBean sessionBean;

    @Autowired
    private SkateBuddyService service;

    @Autowired
    private UserService userService;

    @GetMapping("/import")
    public RestResponse<List<Activity>> importNewActivities(){
        if(sessionBean.getUser().getAccessToken() == null || sessionBean.getUser().getAccessToken().isEmpty()){
            return new RestResponse<List<Activity>>(false,"AUTHORIZATION_REQUIRED");
        }
        return new RestResponse<List<Activity>>(service.importNewActivities(sessionBean.getUser(),false));
    }

    @GetMapping("/get")
    public List<Activity> getActivities(){
        return service.getActivities(sessionBean.getUser());
    }

    @DeleteMapping("/delete")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteActivity(@RequestParam("id") long id){
        Activity act = service.getActivity(sessionBean.getUser(),id);
        service.deleteActivity(sessionBean.getUser(),id);
        service.recalculateStatsAndWheels(sessionBean.getUser(),act,null);
    }

    @PutMapping("/change")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void changeWheels(@RequestBody Activity activity){
        Activity act = service.getActivity(sessionBean.getUser(),activity.getId());
        service.updateActivity(activity);
        service.recalculateWheel(act.getWheel());
        service.recalculateWheel(activity.getWheel());
    }

}
