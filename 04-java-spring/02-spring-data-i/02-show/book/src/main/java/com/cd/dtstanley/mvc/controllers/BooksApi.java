package com.cd.dtstanley.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cd.dtstanley.mvc.models.Book;
import com.cd.dtstanley.mvc.services.BookService;
@RestController
public class BooksApi {
	//private final BookService bookService; // = null;
    private BookService bookService;
    public void Books(BookService bookService){
        this.bookService = bookService;
    }
    
    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }
    
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(@RequestParam(value="title") String bookTitle, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(bookTitle, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }
    
//  //creating post mapping that post the book detail in the database (at same time of Edit) 
//    @PutMapping("/books/edit/{book.id}")
//    public String updateBook(@PathVariable("book.id")Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
//    	System.out.println("id= " + id + " book.id= "+ book.getId());
//    	if(result.hasErrors()) {
//   		System.out.println("Therer is an error in PostMapping for edit.");
//   		 return "/books/edit.jsp";
//   	 }else {
//   		System.out.println("Yes, made it to line 85 in controller.");
//   		System.out.println("id= " + id + " book.id= "+ book.getId());
//   		 bookService.updateBook(book.getId(), book);
//   		 bookService.updateBook(id, book);
//   		 return "redirect:/books";
//   	 }
//    }
    
}//end of BooksApi
