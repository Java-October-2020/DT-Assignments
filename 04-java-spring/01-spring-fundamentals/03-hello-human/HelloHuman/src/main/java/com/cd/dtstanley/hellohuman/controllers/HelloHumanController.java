package com.cd.dtstanley.hellohuman.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController {
@RequestMapping ("/")
public String helloHuman() {
	return "Welcome to Spring Boot";
}
@RestController
public class HelloHumController {
    @RequestMapping("/")
    public String index(Model model, @RequestParam(value="name", required=false, defaultValue="Human") String name) {
    	model.addAttribute("name",name);
        return "index.jsp";
    }
}

}
