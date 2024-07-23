package com.spring.demo.controller;

import com.spring.demo.coach.CricketCoach;
import com.spring.demo.coach.FootballCoach;
import com.spring.demo.coach.TennisCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private CricketCoach cricketCoach;
    private FootballCoach footballCoach;
    private TennisCoach tennisCoach;

    @Autowired
    public MainController(CricketCoach cricketCoach) {
        System.out.println("Constructor: MainController");
        this.cricketCoach = cricketCoach;
    }

    @RequestMapping("lazy")
    public String lazy() {
        return "This is lazy initialization example";
    }
    //When all the beans are lazy. Controller is also lazy, it is only instantiated when there is a API call
    //So in this case when there is a call to /lazy the constructor of MainController is called and CricketCoach is injected, due to which it is also initialized.
}
