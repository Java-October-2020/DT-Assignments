package com.cd.dtstanley.prodandcat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cd.dtstanley.prodandcat.models.Categories;
import com.cd.dtstanley.prodandcat.models.Products;

@Repository
public interface CategoriesRepository extends CrudRepository <Categories, Long>{//identify object and type of primary key in diamond
	// this method retrieves all the persons from the database
    List<Categories> findAll();			//Select * From Categories
	  //this method find a user by the index
    //    List<Persons> findPersonsById();
    //    List<Persons> findPersonsByLicensesId();
    //    Persons save(List<Persons> peeps);
   List<Categories> findByProductsIdIsNull();
   List<Categories> findByProductsNotContains(Products products);
    
    // this method find a person by their description
	//    List<Languages> findByDescriptionContaining(String search);
	    // this method counts how many titles contain a certain string
	//    Long countByTitleContaining(String search);
	    // this method deletes a person that starts with a specific title
	//    Long deleteByTitleStartingWith(String search);
}
//Get these free with CrudRepository
//C - Create
//R - Read
//U - Update
//D - Delete
