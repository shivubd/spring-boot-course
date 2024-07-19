package com.spring.boot.course.spring_di.Coach;

import org.springframework.stereotype.Component;

@Component("hockey")
public class HockeyCoach implements Coach{
    public String workout() {
        return "Do dribbling for 30m";
    }
}
