package com.cd.dtstanley.license.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cd.dtstanley.license.models.Licenses;


	@Repository
	public interface LicensesRepository extends CrudRepository<Licenses, Long> { //identify object and type of primary key in diamond
	    // this method retrieves all the books from the database
	    List<Licenses> findAll();
	    // this method find a book by their description
	//    List<Languages> findByDescriptionContaining(String search);
	    // this method counts how many titles contain a certain string
	//    Long countByTitleContaining(String search);
	    // this method deletes a book that starts with a specific title
	//    Long deleteByTitleStartingWith(String search);
	    //this method find a user by the index
	    List<Licenses> findLicensesById(Long id);
	    Licenses save(List<Licenses> lics);
	    Licenses findTopByOrderByNumberDesc();
	}


//Get these free with CrudRepository
//C - Create
//R - Read
//U - Update
//D - Delete
