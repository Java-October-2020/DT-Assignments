package com.cd.dtstanley.prodandcat.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;


@Entity
@Table(name= "associated")
public class Associated {

	// Create Table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	   
    
 // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    private Date createdAt;
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
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="products_id")
    private Products products;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="categories_id")
    private Categories categories;
    
    
    //Getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	public Categories getCategories() {
		return categories;
	}
	public void setCategories(Categories categories) {
		this.categories = categories;
	}
	public Associated() {
	}
	
}//end of Associated
