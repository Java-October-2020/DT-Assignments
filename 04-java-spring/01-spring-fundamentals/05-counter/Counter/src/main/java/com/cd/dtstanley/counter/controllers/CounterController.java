package com.cd.dtstanley.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CounterController {

	private Integer sessCount;

	@RequestMapping("/")
	public String homeView(HttpSession s) {
		int presCount = index(s);
		setSessionCount(s, presCount++);
		return "index.jsp";
	}
	
	//Get session count
	private int index(HttpSession session){
        // check if a key exists in session with the name "count"
        if(session.getAttribute("count") == null) {
            // no key found!  set session "count" to 0
            session.setAttribute("count", 0);
             Object sessCount = session.getAttribute("count");
            System.out.println("count = " + sessCount);
        }
        return (Integer)sessCount;
    }
	
	//Set session count
	private void setSessionCount(HttpSession sessn, int num) {
		sessn.setAttribute("count", num);
	}
	
	@RequestMapping("/add/{times}")
	public String Add(@PathVariable("times")String times, HttpSession sess) {
		int t=2;
		try {
			t=Integer.parseInt(times);
		}
		catch(NumberFormatException e) {
			System.out.println(String.format("Exception Thrown %s",  e.getMessage()));
			return "redirect:/";
		}
		int thisCount = index(sess);
		thisCount +=t;
		setSessionCount(sess, thisCount);
		return "index.jsp";
	}
	
	@RequestMapping("/reset")
	public String Reset(HttpSession sess) {
	sess.invalidate();
	return "redirect:/counter";
	}
	
	@RequestMapping("/counter")
	public String Counting(HttpSession ses, Model viewModel) {
		viewModel.addAttribute("count", index(ses));
	return "curVCount.jsp";
	}
}
