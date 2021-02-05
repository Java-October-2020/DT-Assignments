package com.cd.dtstanley.homebudgetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd.dtstanley.homebudgetapp.models.Budget;
import com.cd.dtstanley.homebudgetapp.repositories.BudgetRepository;

@Service
public class BudgetService {
	
	@Autowired
	private BudgetRepository budgetRepo;
	
//	public Budget create(Budget budget) {
//		return this.budgetRepo.save(budget);
//	}
	
	// Get All Budgets
	public List<Budget> retrvBudgets(){
		return this.budgetRepo.findAll();
	}
	
	// Get One Budget
		public Budget getSingleBudget(Long id) {
			return this.budgetRepo.findById(id).orElse(null);
		}
		
		// Create A Budget
		public Budget createBudget(Budget newBudget) {
			return this.budgetRepo.save(newBudget);
		}
		
		// Build the Budget created
		public Budget buildBudget(Budget crtdBudget) {
			return this.budgetRepo.save(crtdBudget);
		}
		
		// Delete A Budget
		public void deleteBudget(Long id) {
			this.budgetRepo.deleteById(id);
		}
		
		// Update a Budget
		public Budget updateBudget(Budget budget) {
			return this.budgetRepo.save(budget);
		}
	
//	public TreeSet<Budget> getAllBudgets(User user){
//		Set<User> users = new TreeSet<>();
//		users.add(user);
//		return budgetRepo.findAll();
////		return budgetRepo.findById(id);
////		return budgetRepo.findByUsers(users);
//	}

}
