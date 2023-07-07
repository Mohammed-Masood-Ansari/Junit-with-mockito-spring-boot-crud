package com.spring.springbootsimpleproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
			info = @Info(
					title = "Student-Crud-Operation",
					version = "2.0.3",
					description = "in this project we can perform crud operation",
					termsOfService = "student-details",
					contact = @Contact(
							name = "Mohammed-Masood-Ansari",
							email = "masoodansari1997@gmail.com"
							)
					)
		)
public class SpringBootSimpleProjectApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootSimpleProjectApplication.class, args);
		
	}

	
}
