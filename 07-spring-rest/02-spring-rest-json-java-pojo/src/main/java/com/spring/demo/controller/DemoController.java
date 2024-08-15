package com.spring.demo.controller;

import com.spring.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Shivaraj", "D", "sbd@gmail.com"));
        students.add(new Student(2,"Swati", "Deyannavar", "sd@gmail.com"));
        students.add(new Student(3,"Mukta", "D", "md@gmail.com"));
        students.add(new Student(4,"Basavaraj", "D", "bsd@gmail.com"));

        return students;
    }

}
