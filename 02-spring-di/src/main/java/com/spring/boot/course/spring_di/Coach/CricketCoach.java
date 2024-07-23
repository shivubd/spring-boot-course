package com.spring.boot.course.spring_di.Coach;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("cricket")
public class CricketCoach implements Coach{
    public String workout() {
        return "Do fast bowling for 30m";
    }
}
