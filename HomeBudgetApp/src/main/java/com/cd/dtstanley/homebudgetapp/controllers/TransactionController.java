package com.cd.dtstanley.homebudgetapp.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cd.dtstanley.homebudgetapp.models.Transaction;
import com.cd.dtstanley.homebudgetapp.models.User;
import com.cd.dtstanley.homebudgetapp.services.TransactionService;
import com.cd.dtstanley.homebudgetapp.services.UserService;

@Controller
@RequestMapping("/transacting")
public class TransactionController {

		
		@Autowired
		private UserService uService;

		@Autowired
		private TransactionService transSvc;
		
		@GetMapping("")
		public String retrvTransactn(Model viewModel, @ModelAttribute("transaction") Transaction transaction, HttpSession session) {
			//this method should retrieve a transaction from the database
			System.out.println("cntrl Line 33 of BCtrlr");	
			if(session.getAttribute("user_id").equals(null)) {
				System.out.println("cntrl Line 35 of BCtrlr: user_id is null");
				return "redirect:/";
			}
			User user = this.uService.getSingleUser((Long)session.getAttribute("user_id"));
//			System.out.println("cntrl Line 40 of TCtrlr - user_id:" + user);
//			System.out.println("cntrl Line 41 of TCtrlr");

			List<Transaction> allTrans= this.transSvc.retrvTransactions();

			viewModel.addAttribute("allTrans", allTrans);
//			System.out.println("cntrl Line 48 of BCtrlr");
			viewModel.addAttribute("user", user);
//			System.out.println("cntrl Line 50 of BCtrlr");
		
			return "transacting/addTransactn.jsp";
		}
		
		@GetMapping("/add")
		public String addTrans(@ModelAttribute("transaction") Transaction transaction) {
			return "transacting/addTransactn.jsp";
		}	
		
		@PostMapping("/add")
		public String addC(@Valid @ModelAttribute("transaction") Transaction transaction, BindingResult result, HttpSession session) {
			if(result.hasErrors()) {
				System.out.println("cntrl Line 66  of TCtrlr: error");
				return "transacting/addTransactn.jsp";
			}
			Long userId = (Long)session.getAttribute("user_id"); //instead of having a hidden form, this and next 2 lines
			User owner = this.uService.getSingleUser(userId);
//			transaction.setsetOwner(owner); //setting the user as the owner of this car
			this.transSvc.createTransaction(transaction);
			return "redirect:/transacting";
		}
		
		

} //end of TransactionCtrlr
