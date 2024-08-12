package com.spring.cruddemo.dao.implementation;

import com.spring.cruddemo.dao.StudentDao;
import com.spring.cruddemo.entity.Student;
import com.spring.cruddemo.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

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

    public Student findStudentById(int id) {
        try {
            return studentRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudentNameById(int id, String firstName) {
        try {
            Student student = studentRepository.findById(id).get();
            student.setFirstName(firstName);
            return studentRepository.save(student);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public int deleteStudentById(int id) {
        try {
            studentRepository.deleteById(id);
            return 1;
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    public int deleteAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        if(!studentList.isEmpty()) {
            studentRepository.deleteAll(studentList);
            return studentList.size();
        } else {
            return 0;
        }
    }

    public List<Student> getStudentsListIdGreaterThan(int id) {
        List<Student> studentList = studentRepository.getStudentsListIdGreaterThan(id);
        return studentList;
    }

    @Override
    public List<Student> getStudentLastNameContains(String givenName) {
        return studentRepository.getStudentLastNameContains(givenName);
    }

    @Override
    public void updateLastOfStudentWithId(int id, String givenName) {
        studentRepository.updateLastOfStudentWithId(id, givenName);
    }

    @Override
    public void deleteStudentWithName(String givenName) {
        studentRepository.deleteStudentWithName(givenName);
    }
}
