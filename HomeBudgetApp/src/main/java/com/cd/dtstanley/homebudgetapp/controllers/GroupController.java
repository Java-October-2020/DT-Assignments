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

import com.cd.dtstanley.homebudgetapp.models.Budget;
import com.cd.dtstanley.homebudgetapp.models.Groupset;
import com.cd.dtstanley.homebudgetapp.models.Transaction;
import com.cd.dtstanley.homebudgetapp.models.User;
import com.cd.dtstanley.homebudgetapp.services.BudgetService;
import com.cd.dtstanley.homebudgetapp.services.GroupService;
import com.cd.dtstanley.homebudgetapp.services.TransactionService;
import com.cd.dtstanley.homebudgetapp.services.UserService;

@Controller
@RequestMapping("/grouping")
public class GroupController {

		
		@Autowired
		private UserService uService;
		
		@Autowired
		private BudgetService budgetSvc;
		
		@Autowired
		private TransactionService transSvc;

		@Autowired
		private GroupService groupSvc;
		
		@GetMapping("")
		public String displayBudget(Model viewModel, @ModelAttribute("transaction") Transaction transaction, @ModelAttribute("budget") Budget budget, HttpSession session) {
			//this method should retrieve a Group from the database
			System.out.println("cntrl Line 35 of GCtrlr");	
			if(session.getAttribute("user_id").equals(null)) {
				System.out.println("cntrl Line 37 of GCtrlr: user_id is null");
				return "redirect:/";
			}
			User user = this.uService.getSingleUser((Long)session.getAttribute("user_id"));

//			viewModel.addAttribute("budget", budgetSvc.getSingleBudget(budget.getId()));  //problem Id is null
			List<Transaction> allTrans= this.transSvc.retrvTransactions();
			viewModel.addAttribute("allTrans", allTrans);
			System.out.println("cntrl Line 49 of GCtrlr");
		
		return "budgeting/crBudget.jsp";
		}

		
		@GetMapping("/create")
		public String crGroup(@ModelAttribute("groupset") Groupset groupset) {
			return "grouping/crGroup.jsp";
}
		
		@PostMapping("/create")
		public String createGrp(@Valid @ModelAttribute("groupset") Groupset groupset, BindingResult result, HttpSession session) {
			if(result.hasErrors()) {
				System.out.println("cntrl Line 60  of GCtrlr: error");
				return "grouping/crGroup.jsp";
			}
			Long userId = (Long)session.getAttribute("user_id"); //instead of having a hidden form, this and next 2 lines
			User owner = this.uService.getSingleUser(userId);
			this.groupSvc.createGroup(groupset);
			return "redirect:/grouping";
		}
		
		@GetMapping("/add")
		public String addGroup(@ModelAttribute("groupset") Groupset groupset) {
//			viewModel.addAttribute("groupset", this.groupSvc.getAllGroups());
//			System.out.println("cntrl Line 82  of GCtrlr:" + this.groupSvc.getAllGroups());
			return "grouping/addGroup.jsp";
}

} //end of TransactionCtrlr
