package com.revature.ToDoSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.revature.ToDoSpring.beans")
public class ToDoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoSpringApplication.class, args);
	}

}
