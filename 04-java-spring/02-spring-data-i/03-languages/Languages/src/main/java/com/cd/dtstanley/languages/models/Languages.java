package com.cd.dtstanley.languages.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
@Table(name="languages")
public class Languages {

	// Create Table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @Size(min = 2, max = 20)
    private String name;
    @Column
    @Size(min = 2, max = 20)
    private String creator;
    
//    @Column( columnDefinition = "varchar(255) default <a href=\"/books/edit/${lang.id }\">delete</a> <a href=\"/books/edit/${lang.id }\">edit</a>")
//    private String action;
    
    @Column
    @NotNull
    private Float currentVersion;
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;

    
	// before we save an object
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    // before we save every time
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    
    //getters
    
    public Long getId() {
    	return id;
    }
    
    public String getName() {
    	return name;
    }
    
    public String getCreator() {
    	return creator;
    }
    
    public Float getCurrentVersion() {
    	return currentVersion;
    }
      
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	

	
	//setters
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public void setCurrentVersion(Float currentVersion) {
		this.currentVersion = currentVersion;
	}
	
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

    
  
	public Languages(String name, String creator, Float currentVersion) {
		this.name = name;
		this.creator = creator;
		this.currentVersion = currentVersion;
	//	this.action = action;
	}
	
	public Languages(Long id, String name, String creator, Float currentVersion) {
		this.id= id;
		this.name = name;
		this.creator = creator;
		this.currentVersion = currentVersion;
	}
	public Languages() {
		
	}

}// end of Languages class




