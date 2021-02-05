package com.cd.dtstanley.homebudgetapp.controllers;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cd.dtstanley.homebudgetapp.models.User;

public class LoginController {

//	@GetMapping(value="/login")
//	public String getLogin(ModelMap viewModel)
//	{
//		User user = new User();
//		viewModel.put("user", user);
//		
//		return "login";
//	}
//	
//	@GetMapping("/register")
//	public String retrvRegister(ModelMap viewModel) {
//		User user = new User();
//		viewModel.put("user", user);
//		
//		return "register";
//	}
//	
//	@PostMapping("/register")
//	public String postRegister(@ModelAttribute User user, Model viewModel)
//	{
//		if(!StringUtils.isEmpty(user.getPassword()) && !StringUtils.isEmpty(user.getConfirmPassword()))
//	{
//		if(!user.getPassword().equals(user.getConfirmPassword()))
//		{
//			viewModel.put("error", "Passwords do not match");
//			return "register";
//		}
//			
//	}
//		
//		if(StringUtils.isEmpty(user.getPassword()))
//		{
//			viewModel.put("error", "You must choose a password)");
//		}
//		return "redirect:/budgeting";
//	}
}
