package com.spring.demo.coach;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy //This will make only this class to be instantiated whenever it is injected. (Lazy)
public class CricketCoach {
    public CricketCoach() {
        System.out.println("Constructor: CricketCoach");
    }
}
