package com.cd.dtstanley.prodandcat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cd.dtstanley.prodandcat.models.Categories;
import com.cd.dtstanley.prodandcat.models.Products;

@Repository
public interface ProductsRepository extends CrudRepository<Products, Long> {//identify object and type of primary key in diamond
	// this method retrieves all the persons from the database
    List<Products> findAll();		//Select * From Products
    List<Products> findByCategoriesNotContains(Categories categories);
   List<Products> findByCategoriesIdIsNull();
    
   //this method find a user by the index
   // List<Persons> findPersonsById();
   // List<Persons> findPersonsByLicensesId();
   // Persons save(List<Persons> peeps);
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

