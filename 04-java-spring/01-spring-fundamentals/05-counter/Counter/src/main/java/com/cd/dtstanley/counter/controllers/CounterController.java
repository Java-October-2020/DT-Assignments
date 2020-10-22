package com.cd.dtstanley.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CounterController {

	@RequestMapping("/")
	public String homeView(HttpSession s) {
	if(s.getAttribute("count") == null) {
		// no key found!  set session "count" to 0
		s.setAttribute("count", 0);
	}else {
		int thisCount = (int)s.getAttribute("count");
		thisCount++;
		s.setAttribute("count", thisCount);
	}
//		int presCount = index(s);
//		setSessionCount(s, presCount++);
		return "index.jsp";
	}
	
//	//Get session count
	@RequestMapping("/add/{times}")
	public String Add(@PathVariable("times")String times, HttpSession sess) {
		//String thisCount = "0";
		
		int thisCount = (int)sess.getAttribute("count");
		thisCount = thisCount + Integer.parseInt(times);
		

		sess.setAttribute("count", thisCount);
//		try {
//			t=Integer.parseInt(times);
//		}
//		catch(NumberFormatException e) {
//			System.out.println(String.format("Exception Thrown %s",  e.getMessage()));
//			return "redirect:/";
//		}
		return "curVCount.jsp";
	}

	@RequestMapping("/reset")
	public String Reset(HttpSession sess) {
//	sess.invalidate();
//	int thisCount = (int)sess.getAttribute("count");
	int thisCount = 0;
	sess.setAttribute("count", thisCount);  // If session is invalidated (line 51), can not setAttribute
	return "redirect:/";
	}
	
	@RequestMapping("/counter")
	public String Counting(HttpSession ses, Model viewModel) {
		viewModel.addAttribute("count", ses.getAttribute("count"));
	return "curVCount.jsp";
	}
}
