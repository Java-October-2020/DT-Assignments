package com.cd.dtstanley.thecode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TheCodeController {
	private Boolean isCodeCorrect(String attempt) {
		return attempt.equals("bushido");
	}
	
	private String[] getQualities(){
		return new String[] {
		"Tenacity", 
		"Integrity", 
		"Patience", 
		"Loyalty", 
		"Courage", 
		"Honesty", 
		"Veracity",
		"Compassion",
		"Honor",
		"Faith",
		"Vision",
		"Ensight",
		"Empathy",
		"Leadership",
		"Responsible",
		};
	}
	@RequestMapping("/")
	public String Index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/guess", method=RequestMethod.POST)
	public String Guess(@RequestParam(value="guess") String guess, Model viewModel, RedirectAttributes rAttributes) {
		if(isCodeCorrect(guess)) {
			return "redirect:/code";
		}
		rAttributes.addFlashAttribute("error", "You are yet a young grasshopper.");
		return "redirect:/";
	}
	
	@RequestMapping("/code")
	public String Code(Model viewModel) {
	viewModel.addAttribute("qualities", getQualities());
	return "code.jsp";
	}
	
}//end of TheCodeController
