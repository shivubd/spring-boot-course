package com.spring.demo.config;

import com.spring.demo.coach.Coach;
import com.spring.demo.coach.CricketCoach;
import com.spring.demo.coach.FootballCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CoachConfig {
    @Bean
    @Primary
    public Coach cricketCoach() {
        return new CricketCoach();
    }

    @Bean("football")
    public Coach footballCoach() {
        return new FootballCoach();
    }
}
