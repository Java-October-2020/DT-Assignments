package com.cd.dtstanley.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cd.dtstanley.mvc.models.Book;
import com.cd.dtstanley.mvc.services.BookService;

@RestController								//will be without .jsp views, but will respond with data.
@RequestMapping("/api")
public class APIBooksController {
    private BookService bookService;	//injecting our service 
    
    //public Books(BookService bookService)
    public APIBooksController(BookService bookService) {		//constructor
        this.bookService = bookService;
    }
    
//    //update or edit a book
//    @PutMapping("book/update{index}")
//    public Book updating(@PathVariable("index") Long index, Book updBook) {
//    	return bookService.updateBook(updBook);
//    }
    
   
//    //Delete a book using a service/going thru api
//    @DeleteMapping("/book/delete/{index}")
//    public String deleting(@PathVariable("index") Long index) {
//    	String delResults = this.bookService.deleteBook(index);
//    System.out.println(delResults);
//    	return "redirect:/books/index.jsp";
//    }
//    
////    @GetMapping("delete/{index}")
////    public  String callDelete() {
////    //	bookService.deleteBook({index});
////    //	return "/book/delete/{index}";
////    	return this.bookService.deleteBook(index);
////    }

    
    //Post update to database
    @PostMapping("/books")
    public String posting(@Valid @ModelAttribute("book") Book newBook, BindingResult result) {
    	if(result.hasErrors()) {
    		System.out.println("Error with BindingResult in posting method");
    		return "/books/new.jsp";
    	}else {
    		this.bookService.createBook(newBook);
    	return "redirect:/";
    	}
    }
    
// Create a new book using API
    public Book create(Book newBook) {
    	return this.bookService.createBook(newBook);
    }
    
    @GetMapping("")
    public List<Book> start(){
    	return this.bookService.getAllBooks();
    }
    
    @GetMapping("{index}")
    public Book getBook(@PathVariable("index") Long index) {
    	return this.bookService.getABook(index);
    }

//    @GetMapping("/")
//    public String start(Model viewModel) {
//    	List<Book> theseBooks = this.bookService.getAllBooks();
//    	viewModel.addAttribute("allBooks",theseBooks);
// //   	 if(!theseBooks.equals(null)) {System.out.println("books is not null in controller! Why is nothing displaying in view?");}
//    	return "/books/index.jsp";
//    	
//    }
//    
//    @GetMapping("/{index}")
//    public String retrvBook(@PathVariable("index") Long index) {
//    	bookService.getABook(index);
//    	return "/books/showBook.jsp";
//    	//to pass back to service
//    	//return this.bookService.getABook(index);
//    }
//    
//    

//    
//    
//    
////    @RequestMapping("/books")
////    public String index(Model model) {
////            List<Book> books = bookService.getAllBooks();
////        model.addAttribute("books", books);
////        return "/books/index.jsp";
////        }
    
}//end of BooksController
