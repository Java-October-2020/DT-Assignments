package com.cd.dtstanley.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.cd.dtstanley.mvc.models.Book;
import com.cd.dtstanley.mvc.repositories.BookRepository;
@Service
public class BookService {	//service sends the commands
	
	   
    // adding the book repository as a dependency
   private final BookRepository bookRepo;
    
    public BookService(BookRepository bkRepo) {		//constructor
        this.bookRepo = bkRepo;
    }
    // returns all the books
      public List<Book> getAllBooks() {
    	  // public BookRepository allBooks() {
    	  if(!bookRepo.equals(null)) {System.out.println("Repository is not null!");}
        return bookRepo.findAll();
    }
      
    // creates a book by calling a service
    public Book createBook(Book crBook) {
        return this.bookRepo.save(crBook);
    }
    
    // retrieves a book (Read) by calling a service
    public Book getABook(Long id) {
        return this.bookRepo.findById(id).orElse(null);
    }
    
    public Book findBookByIndex(Long index) {
  //      if (index < books.size()){
//            return books.get(index);
        Optional<Book> optionalBook = bookRepo.findById(index);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        }else{
            return null;
        }
    }
    
    //update a book by calling a service
    public Book updateBook(Book updBook) {
    	return bookRepo.save(updBook);
    	}
    
    //delete a book by calling a service
    public String deleteBook(Long id) {
    	bookRepo.deleteById(id);
    	return "Book ID: " + id + "has been deleted.";
    }
	public String deleteBook() {
		// TODO Auto-generated method stub
		return null;
	}

}// end of BookService
