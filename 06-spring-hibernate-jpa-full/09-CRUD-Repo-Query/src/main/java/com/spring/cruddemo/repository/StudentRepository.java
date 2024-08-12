package com.spring.cruddemo.repository;

import com.spring.cruddemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "SELECT * FROM student WHERE id > ?1;", nativeQuery = true)
    List<Student> getStudentsListIdGreaterThan(int id);

    @Query(value = "SELECT s FROM Student s WHERE lastName LIKE %:givenName% ORDER BY firstName", nativeQuery = false)
    List<Student> getStudentLastNameContains(String givenName);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Student SET lastName = :name WHERE id = :studentId")
    void updateLastOfStudentWithId(@Param("studentId") int id, @Param("name") String givenName);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Student s WHERE s.firstName = :givenName")
    void deleteStudentWithName(String givenName);
}
