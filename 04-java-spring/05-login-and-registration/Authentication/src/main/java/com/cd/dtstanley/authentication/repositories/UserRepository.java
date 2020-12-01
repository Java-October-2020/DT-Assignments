package com.cd.dtstanley.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cd.dtstanley.authentication.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	boolean existsByEmail(String email);
    User findByEmail(String email);
    List<User> findAll();
 //   List<User> findUserById();
}
//Get these free with CrudRepository
//C - Create
//R - Read
//U - Update
//D - Delete