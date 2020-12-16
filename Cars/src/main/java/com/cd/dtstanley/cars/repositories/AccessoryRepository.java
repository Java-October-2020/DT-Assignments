package com.cd.dtstanley.cars.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cd.dtstanley.cars.models.Accessory;

@Repository
public interface AccessoryRepository extends CrudRepository<Accessory, Long> {
	List<Accessory> findAll();
}
//Get these free with CrudRepository
//C - Create
//R - Read
//U - Update
//D – Delete

