package com.spring.cruddemo.dao.implementation;

import com.spring.cruddemo.dao.StudentDao;
import com.spring.cruddemo.entity.Student;
import com.spring.cruddemo.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDaoImpl implements StudentDao {

    private StudentRepository studentRepository;

    @Autowired
    public StudentDaoImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(Student student) {
        studentRepository.save(student);
    }
}
