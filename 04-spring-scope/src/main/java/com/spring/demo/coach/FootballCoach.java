package com.spring.demo.coach;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype") //Like this we can make a prototype Bean, we can give also give "singleton" but it is default no need.
public class FootballCoach {
}
