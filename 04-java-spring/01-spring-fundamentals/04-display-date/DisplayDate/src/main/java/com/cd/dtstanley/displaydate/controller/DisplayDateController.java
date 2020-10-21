package com.cd.dtstanley.displaydate.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DisplayDateController {
	
@RequestMapping("/")
public String homePage(Model viewModel) {
	java.util.Date date=new java.util.Date();
	viewModel.addAttribute("itsNow", date);
	return "index.jsp";
}

	//find date and send to date display
@RequestMapping(value = "/{datime}")   
private String datiming(@PathVariable("datime") String datime, Model viewModel) {
		if(datime.equals("date")) {
			SimpleDateFormat dateft= new SimpleDateFormat("E MM.dd.yyyy" );
			viewModel.addAttribute("dformat", dateft.format(new java.util.Date()));
			return "datedisplay.jsp";
		}else if(datime.equals("time")) {
			SimpleDateFormat timeft= new SimpleDateFormat("hh:mm:ss a zzz" );
			viewModel.addAttribute("tformat", timeft.format(new java.util.Date()));
			System.out.println(timeft.format(new java.util.Date()));
			return "timedisplay.jsp";
		}else {
			return "redirect:/";
		}
	}

}
