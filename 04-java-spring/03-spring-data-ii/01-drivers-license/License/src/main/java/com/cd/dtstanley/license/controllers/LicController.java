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
		System.out.println("line 28 of controller in homer()");
		return "/licenses/index.jsp";
	}
	
	@RequestMapping("/persons/new")
	public String addPage(@ModelAttribute("persons")Persons pers)
	{
		return "/licenses/newpers.jsp";
	}
	@PostMapping("/persons/add")
	public String addPerson(@ModelAttribute("persons")Persons pers, BindingResult result)
	{
		if (result.hasErrors())
		{
			return "/licenses/index.jsp";
		}
		else
		{
			this.licService.addPerson(pers);
//			return "redirect:/persons/new";
			return "redirect:/";
		}
	}
	
	@RequestMapping("/persons/{id}")
	public String display(@PathVariable("id")Long id, Model viewModel)
	{
		Persons pers = this.licService.findPerson(id);
		System.out.println(pers.getFirst_name());
		viewModel.addAttribute("persons", pers);
		return "/licenses/show.jsp";
	}
	
	@RequestMapping("/licenses/new")
	public String licenses(@ModelAttribute("licenses")Licenses lics, Model viewModel)
	{
//		List<Person> pList = this.pService.findAllPerson();
		List<Persons> persList = this.licService.findAllUnlicensed();
		viewModel.addAttribute("persons", persList);
		return "/licenses/newlic.jsp";
	}
	
	@PostMapping("/licenses/new")
	public String newLicense(@Valid @ModelAttribute("licenses")Licenses lics, Model viewModel, BindingResult result)
	{
		System.out.println("Reached line 73 of LicController");
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
