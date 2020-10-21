package com.cd.dtstanley.sampleProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SampleProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleProjectApplication.class, args);
	}
//1. Annotation (removed to place in controller in individual package)
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String hello() {
//		
//		return "DT says, Hello World!";
//	}
}
