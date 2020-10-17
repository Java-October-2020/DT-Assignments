package com.cd.dtstanley.codingcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CodingControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingControllerApplication.class, args);
	}

	@RequestMapping(value = "/coding", method = RequestMethod.GET)
	public String helloCD() {
		return "Hello Coding Dojo!";
	}

	@RequestMapping(value = "/coding/python", method = RequestMethod.GET)
	private String awesome() {
		return "Python/Django was awesome";
	}
	
	@RequestMapping(value = "/coding/java", method = RequestMethod.GET)
	private String better() {
		return "Java/Spring is better";
	}
	
	
}