package com.cd.dtstanley.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cd.dtstanley.dojosninjas.models.Dojo;
import com.cd.dtstanley.dojosninjas.models.Ninja;
import com.cd.dtstanley.dojosninjas.services.AppService;

@Controller
//@RequestMapping("/dashboard")
public class HomeController {
	
	@Autowired
	private AppService appService;
	
//Home or Initial display
	@GetMapping("/")
	public String Homing() {
		return "redirect:/dojos";
	}
	
	
	
	//dojo controllers
	@GetMapping("/dojos")
	public String Index(Model viewModel) {
		viewModel.addAttribute("dojos", appService.allDojos());
		return "/dojos/index.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String MakeNew(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos/newDojo.jsp";
	}
	
	@PostMapping("/dojos")
	public String Create(@Valid @ModelAttribute ("dojo") Dojo dojo, BindingResult result)
	{
		if(result.hasErrors()) {
			System.out.println("Line 46 of HomeController: There was an error");
			return "/dojos/newDojo.jsp";}
		this.appService.addDojo(dojo);
		return "redirect:/dojos";
	}
	
	@RequestMapping("/dojos/{id}")
	public String Show(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("dojo", this.appService.findDojo(id));
		return "/dojos/show.jsp";
	}
	
	//ninja controllers
	
	@RequestMapping("/ninjas")
	public String Indexing(Model viewModel) {
		viewModel.addAttribute("ninjas", this.appService.allNinjas());
		return "/ninjas/indexN.jsp";
	}
	
	@RequestMapping("/ninjas/new")
	public String MakeNinja(@ModelAttribute("ninja") Ninja ninja, Model viewModel) {
		viewModel.addAttribute("dojos", this.appService.allDojos());
		return "/ninjas/newNinja.jsp";
	}
	
	@PostMapping(value="/ninjas")
	public String Create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("dojos", this.appService.allDojos());
			return "/ninjas/newNinja.jsp";
		}
		this.appService.addNinja(ninja);
		return "redirect:/ninjas";
	}
	
	
}//end of HomeController
