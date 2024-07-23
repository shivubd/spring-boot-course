package com.spring.demo.controller;

import com.spring.demo.coach.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
    private Coach coach;
    @Autowired
    public CoachController(@Qualifier("football") Coach coach) {
        this.coach = coach;
    }
    @RequestMapping("/work")
    public String work() {
        return coach.workout();
    }
}
