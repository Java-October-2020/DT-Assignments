package com.cd.dtstanley.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cd.dtstanley.mvc.models.Book;
import com.cd.dtstanley.mvc.services.BookService;

@Controller
public class BooksController {
    private final BookService bookService;
    
    //public Books(BookService bookService)
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @RequestMapping("/")
    public String start(Model model) {
    return "/books/index.jsp";
    }
    
    @RequestMapping("/books")
    public String index(Model model) {
            List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/index.jsp";
        }
    
    
    @RequestMapping("/books/{id}")
    public String findBookByIndex(@PathVariable("id") Long id, Model model) {
     //   Book book = bookService.findBookByIndex(id);
    	System.out.println("Reached line 44 in BooksController");
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "/books/showBook.jsp";
    }

    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/new.jsp";
    }
    
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
     //Edit book
        @RequestMapping("/books/edit/{book.id}")
        public String editBook(@PathVariable("book.id") Long id, Model model) {
        	Book book = bookService.findBookByIndex(id);
        	if(book != null) {
  //      		System.out.println("Yes, made it to line 67 in BookController." + "Id= " + id);
        		model.addAttribute("book", this.bookService.findBook(id));
        	return "/books/edit.jsp";
        }else {
    //    	<br><h1><c:out value="The book does not exist."/></h1><br>;  <<< Only works in html/jsp file
        	System.out.println("The book does not exist.");
        	return "redirect:/books";
        }
        
    }
        
        //creating post mapping that post the book detail in the database (at same time of Edit) 
       // @RequestMapping(value = "/books/edit/{book.id}", method= RequestMethod.PUT)
        @PostMapping("/books/edit/{book.id}")
        public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("book.id") Long id) {
        //	System.out.println("id= " +" book.id= " + id + " or " + book.getId());
        	if(result.hasErrors()) {
       		System.out.println("Therer is an error in PostMapping for edit.");
       		 return "/books/edit.jsp";
       	 }else {
//       		System.out.println("Yes, made it to line 85 in BookController.");
//      		System.out.println("id= " + " book.id= "  + id + ", title= " + book.getbookTitle() + ", Descr= " + book.getDescription());
       		book.setId(id);
       		this. bookService.updateBook(book);
       		
       		 return "redirect:/books";
       	 }
        }

        //	Delete Book
//   //     @RequestMapping(value="/books/delete/${book.id}", method=RequestMethod.PUT)
//        @PostMapping("/books/delete/${book.id}")
//        public String removeBook(@PathVariable("book.id") Long id) {
////        public String deleteBook(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("book.id") Long id) {
////        	System.out.println("id= " +" book.id= " + id + " or " + book.getId());
////        	if(result.hasErrors()) {
////       		System.out.println("There is an error in PostMapping for edit.");
////       		 return "/books/edit.jsp";
////       	 }else {
//       		System.out.println("Yes, made it to line 104 in BookController.");
////      		System.out.println("id= " + " book.id= "  + id + ", title= " + book.getbookTitle() + ", Descr= " + book.getDescription());
////       		book.setId(id);
//       		System.out.println(this.bookService.deleteBook(id));
//        return "redirect:/books";
////       	 }
 //       }
    
}//end of BooksController
