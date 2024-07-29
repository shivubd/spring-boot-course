package com.spring.cruddemo;

import com.spring.cruddemo.dao.StudentDao;
import com.spring.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			createStudent();
		};
	}
	//THIS RUNS AFTER ALL THE BEANS ARE LOADED

	public void createStudent() {
		Student student = new Student("Shivaraj","Deyannavar", "sbd@gmail.com");
		System.out.println("Creating a new Student\n" + student.toString());
		studentDao.save(student);
		System.out.println("Create successfully! Student id = "+student.getId());
	}

}
