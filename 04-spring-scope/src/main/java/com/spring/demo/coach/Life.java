package com.spring.demo.coach;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Life {
    public Life() {
        System.out.println("This is Constructor of Life");
    }
    @PostConstruct
    public void postContruct() {
        System.out.println("This is PostConstruct method of Life"); //This is called after constructor
    }
    @PreDestroy
    public void preDestroy() {
        System.out.println("This is PreDestroy method of Life"); //This is called before the bean is destroyed
    }
    //NOTE: FOR PROTOTYPE SCOPE BEANS, SPRING DOES NOT DESTROY THE BEAN HENCE PreDestroy IS NOT CALLED.
}
