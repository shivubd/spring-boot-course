package com.spring.boot.course.spring_di.controller;

import com.spring.boot.course.spring_di.Coach.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    //Field Injection
    @Autowired
    @Qualifier("cricket")
    private Coach coach;
    //Constructor Injection
    //@Autowired //This is optional if we have only one constructor
    //MyController(Coach coach) {
    //      this.coach = coach;
    //}
    @RequestMapping("daily-workout")
    public String dailyWorkout() {
        return coach.workout();
    }
}

