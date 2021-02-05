package com.cd.dtstanley.homebudgetapp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cd.dtstanley.homebudgetapp.models.Budget;
import com.cd.dtstanley.homebudgetapp.models.Groupset;
import com.cd.dtstanley.homebudgetapp.models.Transaction;
import com.cd.dtstanley.homebudgetapp.models.User;
import com.cd.dtstanley.homebudgetapp.services.BudgetService;
import com.cd.dtstanley.homebudgetapp.services.TransactionService;
import com.cd.dtstanley.homebudgetapp.services.UserService;

@Controller
@RequestMapping("/budgeting")
public class BudgetController {
	
	@Autowired
	private UserService uService;

	@Autowired
	private BudgetService budgetSvc;
	
	@Autowired
	private TransactionService transSvc;
	
	@GetMapping("")
	public String retrvBudget(Model viewModel, @ModelAttribute("budget") Budget budget, HttpSession session) {
		//this method should retrieve a budget from the database
		System.out.println("cntrl Line 33 of BCtrlr");	
		if(session.getAttribute("user_id").equals(null)) {
			System.out.println("cntrl Line 35 of BCtrlr: user_id is null");
			return "redirect:/";
		}
//		User user = this.uService.findUserById((Long)session.getAttribute("user_id"));
		User user = this.uService.getSingleUser((Long)session.getAttribute("user_id"));
//		System.out.println("cntrl Line 40 of BCtrlr - user_id:" + user);
//		System.out.println("cntrl Line 41 of BCtrlr");

	//	TreeSet<Budget> allBudgets= this.budgetSvc.retrvBudgets(user);
	//	List<Budget> allBudgets= this.budgetSvc.retrvBudgets(user);
		List<Budget> allBudgets= this.budgetSvc.retrvBudgets();

		viewModel.addAttribute("allBudgets", allBudgets);
//		System.out.println("cntrl Line 48 of BCtrlr");
		viewModel.addAttribute("user", user);
//		System.out.println("cntrl Line 50 of BCtrlr");
	
		return "budgeting/display.jsp";
	}
	
	@GetMapping("/add")
	public String addBudget(@ModelAttribute("budget") Budget budget) {
		return "budgeting/newBudget.jsp";
	}
	
	@PostMapping("/add")
	public String postBudget(@Valid @ModelAttribute("budget") Budget budget, Model viewModel, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			System.out.println("BContlr Line 70: There is an error");
			return "budgeting/newBudget.jsp";
		}
		ArrayList<User> users = new ArrayList<User>();
		ArrayList<Budget> budgetList = new ArrayList<Budget>();
		
		System.out.println("BContlr Line 76");
		Long userId = (Long)session.getAttribute("user_id"); //instead of having a hidden form, this and next 2 lines
		
		User budgetUsers = this.uService.getSingleUser(userId);
//		budget.setUsers(budgetUsers);
		users.add(budgetUsers);
//		User creator = this.uService.getSingleUser(userId);
//		budget.setCreator(creator);
		this.budgetSvc.createBudget(budget);
		budgetList.add(budget);
		Long budgetId = budget.getId();
		
		System.out.println("BContlr:postBudget exit" + "budgetId = " + budgetId);
//		System.out.println("BContlr:postBudget exit" + "budget name = " + budget.getBudgetName());
//		System.out.println("BContlr:postBudget exit" + "budget year = " + budget.getYear());
//		System.out.println("BContlr:postBudget exit" + "budget month = " + budget.getMonth());
		String bName = budget.getBudgetName();
//		viewModel.addAttribute("budget", budgetSvc.getSingleBudget(budgetId));
//		viewModel.addAttribute("budgetName", bName);
//		viewModel.addAttribute("year", budget.getYear());
//		viewModel.addAttribute("userId", userId);
		budget.setBudgetName(bName);

		return "redirect:/budgeting/create/" + budgetId;
	}
	
	@GetMapping("/create/{id}")
	public String createBudget(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("transaction") Transaction transaction, HttpSession session) {   //model.addAttribute was not needed here
		viewModel.addAttribute("budget", budgetSvc.getSingleBudget(id));
		List<Transaction> allTrans= this.transSvc.retrvTransactions();
		viewModel.addAttribute("allTrans", allTrans);
	return "budgeting/crBudget.jsp";
	}
	
	@PostMapping("/create")
	public String postCrBudget(@Valid @ModelAttribute("budget") Budget budget, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			System.out.println("BContlr:postCrBudget Line 98: There is an error");
			return "budgeting/crBudget.jsp";
		}
		ArrayList<User> users = new ArrayList<User>();
		ArrayList<Budget> budgetList = new ArrayList<Budget>();
		
		System.out.println("BContlr:postCrBudget Line 104");
		Long userId = (Long)session.getAttribute("user_id"); //instead of having a hidden form, this and next 2 lines
		Long budgetId = budget.getId();
		User budgetUsers = this.uService.getSingleUser(userId);
//		budget.setUsers(budgetUsers);
		users.add(budgetUsers);
		
		Groupset group = new Groupset();
		group.setBudget(budget);
		group.setGroupName("groupName");		//groupName needs to be retrieved from model not in quotes?
		budget.getGroups().add(group);
		
//		User creator = this.uService.getSingleUser(userId);
//		budget.setCreator(creator);
		this.budgetSvc.buildBudget(budget);
		budgetList.add(budget);
		
		System.out.println("BContlr:postCrBudget exit");
		return "redirect:/budgeting";
	}
	
	@GetMapping("/show/{id}")  //budgetId?
	public String getBudget(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("budget") Budget budget, HttpSession session) {
			viewModel.addAttribute("budget", budgetSvc.getSingleBudget(id));
			viewModel.addAttribute("userId", (Long)session.getAttribute("user_id"));
			return "budgeting/showBudget.jsp";
		}
	

}
