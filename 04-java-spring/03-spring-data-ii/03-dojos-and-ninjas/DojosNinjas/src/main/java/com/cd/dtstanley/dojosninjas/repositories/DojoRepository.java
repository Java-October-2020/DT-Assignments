package com.cd.dtstanley.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cd.dtstanley.dojosninjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long>{
	
    List<Dojo> findAll();
    
    // get all dojos
    @Query("SELECT d FROM Dojo d")
    List<Dojo> findAllDojos();
    
    // get all the names of the dojos
    @Query("SELECT d.name From Dojo d")
    List<Dojo> findAllDojosNames();
    
    // passing params and filtering (still retrieves a list)
    @Query("SELECT d FROM Dojo d WHERE id = ?1")
    List<Dojo> getDojoWhereId(Long id);
    
    // passing params and filtering
    @Query("SELECT d FROM Dojo d WHERE id = ?1")
    Dojo getSingleDojoWhereId(Long id);
}
//Get these free with CrudRepository
//C - Create
//R - Read
//U - Update
//D - Delete