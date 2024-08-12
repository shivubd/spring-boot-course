package com.spring.cruddemo.dao;

import com.spring.cruddemo.entity.Student;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentDao {
    public void save(Student student);
    public Student findStudentById(int id);
    public List<Student> findAllStudents();
}
