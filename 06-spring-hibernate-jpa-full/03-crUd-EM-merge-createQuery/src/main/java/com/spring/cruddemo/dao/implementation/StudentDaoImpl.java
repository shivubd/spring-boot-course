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
        String query = "UPDATE Student SET lastName = '" + changedName + "' WHERE email LIKE '%" + mailType + "'";
        return entityManager.createQuery(query).executeUpdate();
    }
    @Transactional
    public int deleteStudentById(int id) {
        Student student = entityManager.find(Student.class, id);
        //We need to fetch the object required to delete inside this method because if we fetch it outside,
        // entity manager will be managing that object and we cannot delete that.
        if(student != null) {
            entityManager.remove(student);
            return 1;
        } else return 0;
    }

    @Transactional
    public int deleteStudentsByMailType(String mailType) {
        String query = "DELETE FROM Student WHERE email NOT LIKE '%"+mailType+"'";
        return entityManager.createQuery(query).executeUpdate();
    }
}
