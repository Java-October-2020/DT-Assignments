package com.cd.dtstanley.homebudgetapp.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cd.dtstanley.homebudgetapp.models.User;
import com.cd.dtstanley.homebudgetapp.services.UserService;
import com.cd.dtstanley.homebudgetapp.validators.UserValidator;

@Controller
//@RequestMapping("/dashboard")
public class AuthenticationController {			//same as UserController
	@Autowired
	private UserService userSvc;
	@Autowired
	private UserValidator userVal;

	@RequestMapping("/")
	public String lander(@ModelAttribute("user") User user) {
		
		return "/dashboard/landing.jsp";
	}

	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("myemail")String email, @RequestParam("mypassword")String password, RedirectAttributes redirectAttrs) {
	//public String login(HttpSession session, Model viewModel, @RequestParam("users")Long id) {
//		if(session.getAttribute("user_id") == null) {
//			session.setAttribute("user_id", id);
//		}
		
		if(!this.userSvc.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credentials");
			System.out.println("cntrl Line 42: Error with authentication");
			return "redirect/";
		}
		User user = this.userSvc.getByEmail(email);
		session.setAttribute("user_id", user.getId());
		//return "redirect:/dashboard";   //valuable if I had separate controllers
//		return "redirect:/index.jsp";
//		return "/dashboard/index.jsp";
		return "redirect:/budgeting";		//Access into the application starts here
	}

	@PostMapping("/register")
	public String registering(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userVal.validate(user, result);
		if(result.hasErrors()) {
			//If there are validation errors:
			//We want to return the user directly to the registration page
			return "/dashboard/landing.jsp";
		}
		User newUser = this.userSvc.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		
//		return "redirect:/index.jsp";
		return "/dashboard/index.jsp";
	}


		
	@RequestMapping("/logout")
	public String logingout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

		
	}// end of AuthenticationController
