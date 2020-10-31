package com.cd.dtstanley.mvc.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //increments Id value each time
    private Long id;
    @Column
    @Size(min = 15, max = 200)
    @NotBlank
    private String bookTitle;
    @Column
    @Size(min = 15, max = 200)
    private String author;
    
    @Column
    @Size(min = 15, max = 400)
    private String description;
    
    @Column
    @Size(min = 3, max = 40)
    private String language;
    
    @Column
    @Min(100)
    private int numberOfPages;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    // ...

    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getbookTitle() {
		return bookTitle;
	}
	public void setbookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Book(Long id, String bookTitle, String description, String language, int numberOfPages, Date createdAt,
			Date updatedAt) {
		super();
		this.id = id;
		this.bookTitle = bookTitle;
		this.description = description;
		this.language = language;
		this.numberOfPages = numberOfPages;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public Book(Long id, String bookTitle, String author, String description, String language, int numberOfPages, Date createdAt,
			Date updatedAt) {
		super();
		this.id = id;
		this.bookTitle = bookTitle;
		this.author = author;
		this.description = description;
		this.language = language;
		this.numberOfPages = numberOfPages;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public Book(String bookTitle, String desc, String lang, int pages) {
        this.bookTitle = bookTitle;
        this.description = desc;
        this.language = lang;
        this.numberOfPages = pages;
    }
	
	public Book(String bookTitle, String author, String desc, String lang, int pages) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.description = desc;
        this.language = lang;
        this.numberOfPages = pages;
    }

    
    public Book() {
    	
    }
    
    public void createdAt() {
    	
    }
    
    public void updatedAt() {
    	
    }
	public Book  setbookTitle(Book book) {
		// TODO Auto-generated method stub
		return book;
	}
}// end of Book class
