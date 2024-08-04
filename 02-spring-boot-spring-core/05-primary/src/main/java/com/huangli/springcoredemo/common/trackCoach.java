package com.huangli.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class trackCoach implements Coach
{
    @Override
    public String getDailyWorkout() {
        System.out.println("In constructor: "+getClass());
        return "Run a hard 5k!";
    }
}
