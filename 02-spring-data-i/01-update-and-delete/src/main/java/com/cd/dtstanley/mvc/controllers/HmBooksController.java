package com.cd.dtstanley.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cd.dtstanley.mvc.models.Book;
import com.cd.dtstanley.mvc.services.BookService;

@Controller								//This controller will have html or .jsp views
public class HmBooksController {

	@Autowired							//injecting our service thru a shortcut process
	  private BookService bookService;	//injecting our service 
	 
	  @GetMapping("/")
	  public String index(Model viewModel) {					//First displays all books
		  List<Book> books = this.bookService.getAllBooks();
		  viewModel.addAttribute("allBooks", books);
		  return "/books/index.jsp";
	  }
	  
//	  @PostMapping("/add")
//	  public String addBook(@RequestParam("bookTitle")String bookTitle, @RequestParam("author") String author, @RequestParam("description") String description, @RequestParam("language") String language, @RequestParam("numberOfPages") int numberOfPages) {
//		  System.out.println(bookTitle + ", " + author + ", "+ description + ", "+ language + ", "+ numberOfPages);
//		  return "redirect:/add";
//		  }

	 @PostMapping("/add")
	  public String addNewBook(@Valid @ModelAttribute("book") Book newBook, BindingResult result) {
		  if(result.hasErrors()) {
			  System.out.println("There is an error in the addNewBook method due validations in Book class.");
			  return "redirect:/books/new";
		  }else {
				   
		  this.bookService.createBook(newBook);
		  return "redirect:/";
		  }
}
	  
//	  @GetMapping("/add")
//	  public String add()
//	  {
//		  return "/books/new.jsp";
//	  }
    //New Book button selected
    @GetMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) { 
        return "/books/new.jsp";
    }
	    
	    
}// end of HmBooksController
