package com.spring.boot.course.hello_world.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Value("${company.name}")
    private String companyName;
    @Value("${company.employee}")
    private String employeeName;
    @RequestMapping("helloworld")
    public String helloWorld() {
        return "Hello, " + employeeName + " from " + companyName;
    }
}
