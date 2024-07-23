package com.spring.demo.coach;

import org.springframework.stereotype.Component;

@Component //This class will be instantiated at the startup of app, (Non-Lazy)
public class TennisCoach {
    public TennisCoach() {
        System.out.println("Constructor: TennisCoach");
    }
}
