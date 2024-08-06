package com.huangli.springcoredemo.rest;

import com.huangli.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //define a private field for the dependency
    private Coach myCoach;

//    constructor injection
    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach theCoach){
        myCoach=theCoach;

    }

//    setter injection
//    @Autowired
//    public void setCoach(Coach theCoach){
//        myCoach=theCoach;
//
//    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
