package com.spring.cruddemo.dao.implementation;

import com.spring.cruddemo.dao.StudentDao;
import com.spring.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }
    //@Transactional is required as we are modifying database.

    public Student findStudentById(int id) {
        return entityManager.find(Student.class, id);
    }

    public List<Student> findAllStudents() {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s", Student.class);
        return query.getResultList();
    }

    public List<Student> findStudentsWithIdGreaterThan(int id) {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.id > :givenId", Student.class);
        query.setParameter("givenId", id);
        return query.getResultList();
    }

    @Transactional
    public void updateStudentNameById(Student student) {
        entityManager.merge(student);
    }

    @Transactional
    public int updateStudentsLastNameByMailType(String mailType, String changedName) {
        return entityManager.createQuery("UPDATE Student SET lastName = 'TestBulkUpdate' WHERE email LIKE '%@gmail.com'").executeUpdate();
    }
}
