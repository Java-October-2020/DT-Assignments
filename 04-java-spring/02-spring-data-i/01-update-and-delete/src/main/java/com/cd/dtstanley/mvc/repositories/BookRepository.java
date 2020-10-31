package com.cd.dtstanley.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cd.dtstanley.mvc.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{  //identify object and type of primary key in diamond
    // this method retrieves all the books from the database
    List<Book> findAll();
    // this method find a book by their description
    List<Book> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
    Long countByBookTitleContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByBookTitleStartingWith(String search);
}


//Get these free with CrudRepository
//C - Create
//R - Read
//U - Update
//D - Delete