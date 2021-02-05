package com.cd.dtstanley.homebudgetapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cd.dtstanley.homebudgetapp.models.Groupset;

	@Repository
	public interface GroupRepository extends CrudRepository<Groupset, Long> {
			List<Groupset> findAll();
	}//end groupRepo

	//Get these free with CrudRepository
	//C - Create
	//R - Read
	//U - Update
	//D - Delete
	

