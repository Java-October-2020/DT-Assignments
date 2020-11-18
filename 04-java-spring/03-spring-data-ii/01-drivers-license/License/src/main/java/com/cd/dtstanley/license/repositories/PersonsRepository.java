package com.cd.dtstanley.license.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cd.dtstanley.license.models.Persons;


	@Repository
	public interface PersonsRepository extends CrudRepository<Persons, Long>{ //identify object and type of primary key in diamond
	    // this method retrieves all the books from the database
	    List<Persons> findAll();
	    // this method find a book by their description
	//    List<Languages> findByDescriptionContaining(String search);
	    // this method counts how many titles contain a certain string
	//    Long countByTitleContaining(String search);
	    // this method deletes a book that starts with a specific title
	//    Long deleteByTitleStartingWith(String search);
	    //this method find a user by the index
	    List<Persons> findPersonsById();
	    List<Persons> findPersonsByLicensesID();
	    Persons save(List<Persons> peeps);
	    List<Persons> findByLicensesIDIsNull();
	}


//Get these free with CrudRepository
//C - Create
//R - Read
//U - Update
//D - Delete
