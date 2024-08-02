package com.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //inject properties for: coach.name, team.name
    @Value("${coach.name}") private String coachName;
    @Value("${team.name}") private String teamName;

    @GetMapping("/teaminfo")
    public String getTeaminfo(){
        return "Coach" + coachName + ", Team name"+teamName;
    }

    //expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }
    //expose "/workout" that return "run a hard 5k!"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k!";
    }
}

