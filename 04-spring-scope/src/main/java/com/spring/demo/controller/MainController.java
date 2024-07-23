package com.spring.demo.controller;

import com.spring.demo.coach.CricketCoach;
import com.spring.demo.coach.FootballCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private CricketCoach coachOne;
    private CricketCoach coachTwo;
    private FootballCoach footballCoachOne;
    private FootballCoach footballCoachTwo;

    @Autowired
    public MainController(CricketCoach coachOne, CricketCoach coachTwo, FootballCoach footballCoachOne, FootballCoach footballCoachTwo) {
        this.coachOne = coachOne;
        this.coachTwo = coachTwo;
        System.out.println("Is CricketCoach Singleton ? " + (this.coachOne == this.coachTwo));
        System.out.println("Is CricketCoach Prototype ? " + !(this.coachOne == this.coachTwo));

        this.footballCoachOne = footballCoachOne;
        this.footballCoachTwo = footballCoachTwo;
        System.out.println("Is FootballCoach Singleton ? " + (this.footballCoachOne == this.footballCoachTwo));
        System.out.println("Is FootballCoach Prototype ? " + !(this.footballCoachOne == this.footballCoachTwo));

    }
    //SINGLETON BEAN (DEFAULT) - this bean is instantiated only once and the same bean is injected in all dependencies. if there are 10 dependencies then same single instance is injected into all 10 dependencies.
    //PROTOTYPE BEAN - this bean is instantiated each time when injection is done, if there are 10 dependencies then 10 different instances are injected.

}
