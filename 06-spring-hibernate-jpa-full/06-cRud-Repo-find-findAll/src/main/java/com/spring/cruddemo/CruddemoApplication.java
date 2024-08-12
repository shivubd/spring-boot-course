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
			findStudentById();
			findAllStudents();
		};
	}
	//THIS RUNS AFTER ALL THE BEANS ARE LOADED

	public void createStudent() {
		Student student = new Student("Parwati","Deyannavar", "");
		System.out.println("Creating a new Student\n" + student.toString());
		studentDao.save(student);
		System.out.println("Create successfully! Student id = "+student.getId());
	}

	public void findStudentById() {
		int givenId = 8;
		Student student = studentDao.findStudentById(givenId);
		if(student != null) {
			System.out.println("Found student");
			System.out.println(student.toString());
		} else {
			System.out.println("No Student found with id = " + givenId);
		}
		System.out.println();
	}

	public void findAllStudents() {
		List<Student> studentList = studentDao.findAllStudents();
		if(!studentList.isEmpty()) {
			System.out.println("STUDENTS LIST");
			studentList.forEach(student -> {
				System.out.println(student.toString());
			});
		} else {
			System.out.println("NO STUDENTS FOUND");
		}
		System.out.println();
	}
}
