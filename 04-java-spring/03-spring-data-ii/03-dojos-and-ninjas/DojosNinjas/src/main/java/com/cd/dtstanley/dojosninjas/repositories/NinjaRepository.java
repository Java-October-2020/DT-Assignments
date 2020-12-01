package com.cd.dtstanley.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cd.dtstanley.dojosninjas.models.Ninja;


public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	
    List<Ninja> findAll();
    
    // get all Ninjas
    @Query("SELECT d FROM Ninja d")
    List<Ninja> findAllNinjas();
    
//    // get all the names of the Ninjas
//    @Query("SELECT d.name From Ninja d")
//    List<Ninja> findAllNinjasNames();
    
    // passing params and filtering (still retrieves a list)
    @Query("SELECT d FROM Ninja d WHERE id = ?1")
    List<Ninja> getNinjaWhereId(Long id);
    
    // passing params and filtering
    @Query("SELECT d FROM Ninja d WHERE id = ?1")
    Ninja getSingleNinjaWhereId(Long id);
}
//Get these free with CrudRepository
//C - Create
//R - Read
//U - Update
//D - Delete
