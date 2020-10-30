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
    return "redirect:/books";
    }
    
    @RequestMapping("/books")
    public String index(Model model) {
            List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/index.jsp";
        }
    
    
    @RequestMapping("/books/{index}")
    public String findBookByIndex(Model model, @PathVariable("index") Long index) {
        Book book = bookService.findBookByIndex(index);
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
        @RequestMapping("/books/edit/{id}")
        public String editBook(@PathVariable("id") Long id, Model model) {
        	Book book = bookService.findBookByIndex(id);
        	if(book != null) {
        		model.addAttribute("book", book);
        	return "/books/edit.jsp";
        }else {
        //	<br><h1><c:out value="The book does not exist."/></h1><br>;
        	return "redirect:/books";
        }
        
    }
        
        //creating post mapping that post the book detail in the database (at same time of Edit) 
        @PostMapping("/books/edit/{id}")
        public String updateBook(@PathVariable("id")Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
       	 if(result.hasErrors()) {
       		 return "/books/edit.jsp";
       	 }else {
       		 bookService.updateBook(id, book);
       		 return "redirect:/books";
       	 }
        }

    
}//end of BooksController
