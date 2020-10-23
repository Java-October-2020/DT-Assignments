package com.cd.dtstanley.dojosurvey.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cd.dtstanley.dojosurvey.model.Survey;


@Controller
public class DojoSurveyController {

	private String[] getLanguages() {
		return new String[] {
				"Java", "HTML", "JavaScript", "MERN", "C#", "Python"
		};
	}
	
	private String[] getLocations() {
		return new String[] {
				"Seattle", "Dallas", "Atlanta", "San Jose", "Chicago", "Tulsa", "Wilmington"
		};
	}
	
	
	@RequestMapping("/")
	public String Index(Model viewModel) {
		viewModel.addAttribute("languanges", getLanguages());
		viewModel.addAttribute("locations", getLocations());
		return "index.jsp";
	}
	@RequestMapping(value="/survey", method=RequestMethod.POST)
	public String Results(@RequestParam(value="name") String name, 
			@RequestParam(value="location") String location,
			@RequestParam(value="language") String language,
			@RequestParam(value="comment") String comment,
			Model viewModel){
		viewModel.addAttribute("fresult", new Survey(name, location, language, comment));
		return "formresult.jsp";
	}
	@RequestMapping("/reset")
	public String Reset() {
	return "redirect:/";
	}
	
	
	
}
