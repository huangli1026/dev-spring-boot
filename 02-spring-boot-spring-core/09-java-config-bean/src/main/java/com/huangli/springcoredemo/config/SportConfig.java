package com.huangli.springcoredemo.config;

import com.huangli.springcoredemo.common.Coach;
import com.huangli.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    public SportConfig(){
        System.out.println("In constructor"+getClass().getSimpleName());
    }

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
