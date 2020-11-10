package com.cd.dtstanley.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cd.dtstanley.languages.models.Languages;

@Repository
	public interface LanguagesRepository extends CrudRepository<Languages, Long>{ //identify object and type of primary key in diamond
	    // this method retrieves all the books from the database
	    List<Languages> findAll();
	    // this method find a book by their description
	//    List<Languages> findByDescriptionContaining(String search);
	    // this method counts how many titles contain a certain string
	//    Long countByTitleContaining(String search);
	    // this method deletes a book that starts with a specific title
	//    Long deleteByTitleStartingWith(String search);
	    //this method find a user by the index
	    List<Languages> findLanguagesById(Long id);
		Languages save(List<Languages> lang);
	}

//Get these free with CrudRepository
//C - Create
//R - Read
//U - Update
//D - Delete