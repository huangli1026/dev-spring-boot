package com.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World! Test4";
    }
    //expose "/workout" that return "run a hard 5k!"
    @GetMapping("/workout2")
    public String getDailyWorkout(){
        return "Run a hard 52k!";
    }
}

