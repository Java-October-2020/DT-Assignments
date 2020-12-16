package com.cd.dtstanley.cars.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cd.dtstanley.cars.models.Accessory;
import com.cd.dtstanley.cars.services.AccessoryService;
import com.cd.dtstanley.cars.services.CarService;

@Controller
@RequestMapping("/accessory")
public class AccessoryController {
	@Autowired
	private AccessoryService aService;
	@Autowired
	private CarService cService;
	
	@GetMapping("/new")
	public String createAcc(@ModelAttribute("accessory") Accessory accessory, Model viewModel) {
		viewModel.addAttribute("cars", this.cService.getAllCars());
		return "accessory/new.jsp";
	}
	
	@PostMapping("")
	public String create(@Valid @ModelAttribute("accessory") Accessory accessory, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("cars", this.cService.getAllCars());
			return "accessory/new.jsp";
		}
		
		this.aService.create(accessory);
		return "redirect:/cars";
		//		return "cars/index.jsp";
	}
}

