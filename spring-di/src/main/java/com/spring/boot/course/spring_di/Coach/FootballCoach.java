package com.spring.boot.course.spring_di.Coach;

import org.springframework.stereotype.Component;

@Component("football")
public class FootballCoach implements Coach{
    public String workout() {
        return "Do running for 30m";
    }
}
