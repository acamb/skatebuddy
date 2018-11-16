package strava.acambieri.skatebuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import strava.acambieri.skatebuddy.model.SessionBean;
import strava.acambieri.skatebuddy.model.Wheel;
import strava.acambieri.skatebuddy.services.SkateBuddyService;
import strava.acambieri.skatebuddy.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/wheels")
public class WheelsController {

    @Autowired
    private SessionBean sessionBean;

    @Autowired
    private SkateBuddyService service;

    @PostMapping("/add")
    public List<Wheel> addWheel(@RequestBody Wheel wheel){
        service.addWheel(sessionBean.getUser(),wheel,false);
        setCurrentWheel(wheel);
        return service.getWheels(sessionBean.getUser());
    }

    @PostMapping("/current")
    public List<Wheel> setCurrentWheel(@RequestBody Wheel wheel){
        service.setCurrentWheel(sessionBean.getUser(),wheel);
        return service.getWheels(sessionBean.getUser());
    }

    @GetMapping("/get")
    public List<Wheel> getWheels(){
        return service.getWheels(sessionBean.getUser());
    }

    @PutMapping("/rotate")
    public Wheel rotate(@RequestBody Wheel wheel){
        service.rotateWheels(sessionBean.getUser());
        return service.getCurrentWheel(sessionBean.getUser());
    }

    @DeleteMapping("/delete")
    public List<Wheel> delete(@RequestParam Long id){
        service.deleteWheel(id);
        return service.getWheels(sessionBean.getUser());
    }

}
