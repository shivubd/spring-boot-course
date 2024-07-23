package com.spring.boot.course.spring_di.controller;

import com.spring.boot.course.spring_di.Coach.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    //Field Injection
    //@Autowired
    //@Qualifier("cricket")
    private Coach coach;
    private Coach hockeyCoach;
    private Coach cricketCoach;

    //Constructor Injection
    @Autowired //This is optional if we have only one constructor
    MyController(@Qualifier("hockeyCoach") Coach hockeyCoach, @Qualifier("cricket") Coach cricketCoach, Coach coach) {
          this.hockeyCoach = hockeyCoach; //Injected using Qualifier
          this.cricketCoach = cricketCoach; //Injected using Qualifier
          this.coach = coach; //Injected using Primary
    }

    //Setter Injection
    //@Autowired
    //public void setCoach(Coach coach) {
    //    this.coach = coach;
    //}
    //OR WE CAN AUTOWIRE USING ANY METHOD LIKE BELOW
    //@Autowired
    //public void addTwoNumbers(Coach coach) {
    //    this.coach = coach;
    //    System.out.println("Performing action");
    //}
    @RequestMapping("daily-workout")
    public String dailyWorkout() {
        return coach.workout() + " " + cricketCoach.workout() + " " + hockeyCoach.workout();
    }
}

