package com.spring.cruddemo.dao;

import com.spring.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {
    public void save(Student student);
    public Student findStudentById(int id);
    public List<Student> findAllStudents();
    public Student updateStudentNameById(int id, String firstName);
}
