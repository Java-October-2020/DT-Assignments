package com.cd.dtstanley.homebudgetapp.repositories;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cd.dtstanley.homebudgetapp.models.Budget;
import com.cd.dtstanley.homebudgetapp.models.User;

@Repository
public interface BudgetRepository extends CrudRepository<Budget, Long> {
		List<Budget> findAll();
//		TreeSet<Budget> findAll();
//	TreeSet<Budget> findByUsers(Set<User> users);
}
//Get these free with CrudRepository
//C - Create
//R - Read
//U - Update
//D - Delete