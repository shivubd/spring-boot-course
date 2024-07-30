package com.spring.cruddemo;

import com.spring.cruddemo.dao.StudentDao;
import com.spring.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	private StudentDao studentDao;

	@Autowired
	public CruddemoApplication(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		return runner -> {
			System.out.println("App start");
//			createStudent();
//			findStudentById();
//			findAllStudents();
//			findStudentsGreaterThan();
//			updateStudentNameById();
//			updateStudentsNameByMailType();
			deleteStudentById();
			deleteStudentsByMailType();
		};
	}
	//THIS RUNS AFTER ALL THE BEANS ARE LOADED

	public void createStudent() {
		Student student = new Student("Shivaraj","Deyannavar", "sbd@gmail.com");
		System.out.println("Creating a new Student\n" + student.toString());
		studentDao.save(student);
		System.out.println("Create successfully! Student id = "+student.getId());
		System.out.println();
	}

	public void findStudentById() {
		int givenId = 1;
		Student student = studentDao.findStudentById(givenId);
		if(student != null) {
			System.out.println("Found student with id = " + givenId);
			System.out.println(student.toString());
		} else {
			System.out.println("Student not found");
		}
		System.out.println();
	}

	public void findAllStudents() {
		List<Student> students = studentDao.findAllStudents();
		if(!students.isEmpty()) {
			System.out.println("List of all students");
			students.forEach(student -> System.out.println(student.toString()));
		} else {
			System.out.println("No students found");
		}
		System.out.println();
	}

	public void findStudentsGreaterThan() {
		int givenId = 10;
		List<Student> students = studentDao.findStudentsWithIdGreaterThan(givenId);
		if(!students.isEmpty()) {
			System.out.println("List of students whose id > " + givenId);
			for(Student student : students) { //another way of writing forEach
				System.out.println(student.toString());
			}
		} else {
			System.out.println("No students found with id > " + givenId);
		}
		System.out.println();
	}

	public void updateStudentNameById() {
		int givenId = 1;
		String change = "TestUpdate";
		Student student = studentDao.findStudentById(givenId);
		if(student != null) {
			student.setFirstName(change);
			studentDao.updateStudentNameById(student);
			System.out.println("Student updated successfully with id = " + givenId);
			System.out.println("UPDATED ROW");
			System.out.println(studentDao.findStudentById(givenId).toString());
		} else {
			System.out.println("Found no student to update with id = " + givenId);
		}
	}

	public void updateStudentsNameByMailType() {
		String givenName = "TestBulkUpdate";
		String mailType = "@gmail.com";
		int rowsAffected = studentDao.updateStudentsLastNameByMailType(mailType, givenName);
		System.out.println("BULK UPDATE");
		if(rowsAffected > 0) {
			System.out.println(rowsAffected + " Students updated successfully");
		} else {
			System.out.println("No students updated");
		}
	}

	public void deleteStudentById() {
		int givenId = 1;
		int deletedRows = studentDao.deleteStudentById(givenId);
		if(deletedRows == 1) {
			System.out.println("Student is deleted successfully with id = " + givenId);
		} else {
			System.out.println("Found no student to delete with id = " + givenId);
		}
	}

	public void deleteStudentsByMailType() {
		String mailType = "@gmail.com";
		int rowsAffected = studentDao.deleteStudentsByMailType(mailType);
		System.out.println("BULK DELETE");
		if(rowsAffected > 0) {
			System.out.println(rowsAffected + " Students deleted successfully");
		} else {
			System.out.println("No students deleted");
		}
	}
}
