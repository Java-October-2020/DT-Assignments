package com.cd.dtstanley.homebudgetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd.dtstanley.homebudgetapp.models.Transaction;
import com.cd.dtstanley.homebudgetapp.repositories.TransactionRepository;



@Service
public class TransactionService {
	
		@Autowired
		private TransactionRepository transRepo;
		
	// Get All Transactions
	public List<Transaction> retrvTransactions(){
		return this.transRepo.findAll();
	}
	
	// Get One Transaction
		public Transaction getSingleTransaction(Long id) {
			return this.transRepo.findById(id).orElse(null);
		}
		
		// Create A Transaction
		public Transaction createTransaction(Transaction newTransaction) {
			return this.transRepo.save(newTransaction);
		}
		
		// Build the Transaction created
		public Transaction buildTransaction(Transaction crtdTransaction) {
			return this.transRepo.save(crtdTransaction);
		}
		
		// Delete A Transaction
		public void deleteTransaction(Long id) {
			this.transRepo.deleteById(id);
		}
		
		// Update a Transaction
		public Transaction updateTransaction(Transaction transaction) {
			return this.transRepo.save(transaction);
		}
	
} //end TransSvc
