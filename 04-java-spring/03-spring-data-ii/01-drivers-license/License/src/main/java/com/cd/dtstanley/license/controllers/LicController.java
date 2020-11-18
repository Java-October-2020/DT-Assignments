package com.cd.dtstanley.license.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cd.dtstanley.license.models.Licenses;
import com.cd.dtstanley.license.models.Persons;
import com.cd.dtstanley.license.services.LicensesService;

@Controller
public class LicController {

	
	@Autowired	//injecting our service thru a shortcut process
		private LicensesService licService;		//injecting our service
	
	@RequestMapping("/")
	public String homer() {
		return "/licenses/index.jsp";
	}
	
	@RequestMapping("/persons/new")
	public String addPage(@ModelAttribute("person")Persons pers)
	{
		return "/licenses/index.jsp";
	}
	@PostMapping("/persons/new")
	public String addPerson(@ModelAttribute("person")Persons pers, BindingResult result)
	{
		if (result.hasErrors())
		{
			return "/licenses/index.jsp";
		}
		else
		{
			this.licService.addPerson(pers);
			return "redirect:/persons/new";
		}
	}
	
	@RequestMapping("/persons/{id}")
	public String display(@PathVariable("id")Long id, Model m)
	{
		Persons pers = this.licService.findPerson(id);
		System.out.println(pers.getFirst_name());
		m.addAttribute("person", pers);
		return "/licenses/display.jsp";
	}
	
	@RequestMapping("/licenses/new")
	public String licenses(@ModelAttribute("license")Licenses lics, Model viewModel)
	{
//		List<Person> pList = this.pService.findAllPerson();
		List<Persons> persList = this.licService.findAllUnlicensed();
		viewModel.addAttribute("persons", persList);
		return "/licenses/newLic.jsp";
	}
	
	@PostMapping("/licenses/new")
	public String newLicense(@Valid @ModelAttribute("license")Licenses lics, Model viewModel, BindingResult result)
	{
		this.licService.createLicense(lics);
		return "redirect:/licenses/new";
	}
//	@RequestMapping("/")
//	public String Homer(Model viewModel) {
//		List<Persons> peeps=licService.getPersons();
//		viewModel.addAttribute("persons", peeps);
//		return "/Licenses/index.jsp";
//	}
	
}//end of LicController
