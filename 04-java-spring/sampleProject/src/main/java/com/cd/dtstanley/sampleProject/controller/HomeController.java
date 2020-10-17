package com.cd.dtstanley.sampleProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// @RestController  <Replaced due index.jsp
@Controller  //replaced above
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello() {
		
		return "index.jsp";
	}

	@RequestMapping(value = "/purple", method = RequestMethod.GET)
	private String color() {
		return "purple is an awesome color";
	}
}
