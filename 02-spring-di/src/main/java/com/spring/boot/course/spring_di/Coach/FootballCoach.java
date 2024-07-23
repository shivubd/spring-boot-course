package com.spring.boot.course.spring_di.Coach;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{
    public String workout() {
        return "Do running for 30m";
    }
}
