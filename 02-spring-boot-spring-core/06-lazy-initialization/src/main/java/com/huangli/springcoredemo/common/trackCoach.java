package com.huangli.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Lazy
public class trackCoach implements Coach {

    public trackCoach(){
        System.out.println("In constructor"+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        System.out.println("In constructor: "+getClass());
        return "Run a hard 5k!";
    }
}
