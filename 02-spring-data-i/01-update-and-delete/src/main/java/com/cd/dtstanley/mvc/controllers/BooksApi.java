package com.cd.dtstanley.mvc.controllers;

import org.springframework.web.bind.annotation.PathVariable;
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
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
    
    public BooksApi() {
    	
    }
    
  @RequestMapping(value="/api/books/update/{index}", method=RequestMethod.POST)
  public Book updating(@PathVariable("index") Long index, Book updBook) {
  	return bookService.updateBook(updBook);
//  public Book update(@PathVariable("{index}") Long index, @RequestParam(value="bookTitle") String bookTitle, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
//      //Book book = bookService.updateBook(updBook);
//      //.updateBook(bookTitle, desc, lang, numOfPages);
// //Book(bookTitle, desc, lang, numOfPages);
//      return bookService.updateBook(updBook);
  }
  
  @RequestMapping(value="/api/books/delete/{index}", method=RequestMethod.DELETE)
  public void destroy(@PathVariable("index") Long index) {
      bookService.deleteBook(index);
  }
    
//    
//    @RequestMapping("/api/books")
//    public String index() {
//        return bookService.getAllBooks().toString();
//    }
//    
//    @RequestMapping(value="/api/books", method=RequestMethod.POST)
//    public Book create(@RequestParam(value="title") String bookTitle, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
//        Book book = new Book(bookTitle, desc, lang, numOfPages);
//        return bookService.createBook(book);
//    }
//    
//    @RequestMapping("/api/books/{id}")
//    public Book show(@PathVariable("id") Long id) {
//        Book book = bookService.findBookByIndex(id);
//        return book;
//    }
}
