package com.cd.dtstanley.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SuppressWarnings("unused")
@SpringBootApplication
public class HelloHumanApplication {

	//Entry Point Method - it allows this program to run
	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
	}

}
