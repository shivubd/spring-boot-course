package com.spring.boot.course.spring_di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {
				"com.spring.boot.course.spring_di", //have to mention this also!! or else it will not scan this package.
				"component.scan.test"
		}
)
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}
