package com.spring.boot.course.hello_world.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping("helloworld")
    public String helloWorld() {
        return "Hello, World!";
    }
}
