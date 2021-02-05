package com.cd.dtstanley.homebudgetapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cd.dtstanley.homebudgetapp.models.Transaction;



	@Repository
	public interface TransactionRepository extends CrudRepository<Transaction, Long> {
			List<Transaction> findAll();
	}//end transRepo

	//Get these free with CrudRepository
	//C - Create
	//R - Read
	//U - Update
	//D - Delete
	
	
