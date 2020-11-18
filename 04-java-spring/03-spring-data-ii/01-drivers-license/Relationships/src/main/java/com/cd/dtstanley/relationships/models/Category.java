package com.cd.dtstanley.relationships.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="categories")
public class Category {
 
 @Id
 @Column
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 
 @Column
 @Size(min=2, max=50)
 private String name;

 @Column
 @OneToMany(mappedBy="category", fetch = FetchType.LAZY)
 @JsonIgnore
 private List<Category> categoriesProducts;
 
//This will not allow the createdAt column to be updated after creation
 @Column(updatable=false)
 @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
 private Date createdAt;
 
 @Column
 @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
 private Date updatedAt;
     
//before we save an object
 @PrePersist
 protected void onCreate(){
     this.createdAt = new Date();
 }
 // before we save every time
 @PreUpdate
 protected void onUpdate(){
     this.updatedAt = new Date();
 }
 

 // getters and setters 

 
 
public Long getId() {
	return id;
}




public void setId(Long id) {
	this.id = id;
}




public String getName() {
	return name;
}




public void setName(String name) {
	this.name = name;
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




public List<Category> getCategoriesProducts() {
	return categoriesProducts;
}




public void setCategoriesProducts(List<Category> categoriesProducts) {
	this.categoriesProducts = categoriesProducts;
}




public Category() {
     
 }




public Category(String name, List<Category> categoriesProducts) {
	this.name = name;
	this.categoriesProducts = categoriesProducts;
}




public Category(Long id, String name, List<Category> categoriesProducts) {
	this.id = id;
	this.name = name;
	this.categoriesProducts = categoriesProducts;
}




public Category(Long id, String name, Date createdAt, Date updatedAt, List<Category> categoriesProducts) {
	this.id = id;
	this.name = name;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	this.categoriesProducts = categoriesProducts;
}


}//end of Category

