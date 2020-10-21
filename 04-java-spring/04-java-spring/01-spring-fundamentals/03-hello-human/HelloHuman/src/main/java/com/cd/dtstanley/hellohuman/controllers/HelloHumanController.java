package com.cd.dtstanley.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloHumanController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String helloHuman() {
	//	return "Welcome to Spring Boot";
		return "index.jsp";
	}
//    @RequestMapping("/${name}")
//    public String index(Model model, @RequestParam(value="name", required=false, defaultValue="Human") String name) {
//    	model.addAttribute("name",name);
//        return "index.jsp";
//    }
	
	@RequestMapping(value = "/{fname}", method = RequestMethod.GET)
	public String Hello(@PathVariable("fname")String fname, Model viewModel) {
	viewModel.addAttribute("first name", fname);
	return "fname.jsp";
}
	
	@RequestMapping(value = "/{fname}/{lname}", method = RequestMethod.GET)
	public String Hello2(@PathVariable String fname, @PathVariable String lname, Model viewModel) {
	viewModel.addAttribute("favoriteColor", fname);
	viewModel.addAttribute("last name", lname);
	return "flname.jsp";
}
	
}


