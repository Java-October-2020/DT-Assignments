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
@Table(name="products")
public class Product {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    @Size(min=2, max=50)
    private String name;
    
    @Column
    @Size(max=50)
    private String description;
    
    @Column
    @Size(min=1, max=20)
    private float price;
    
    @Column    
    @OneToMany(mappedBy="product", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CategoryProduct> categoriesProducts;
    
 // This will not allow the createdAt column to be updated after creation
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
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


	public List<CategoryProduct> getCategoriesProducts() {
		return categoriesProducts;
	}


	public void setCategoriesProducts(List<CategoryProduct> categoriesProducts) {
		this.categoriesProducts = categoriesProducts;
	}


public Product() {
        
    }


public Product(String name, String description, float price, List<CategoryProduct> categoriesProducts) {
	super();
	this.name = name;
	this.description = description;
	this.price = price;
	this.categoriesProducts = categoriesProducts;
}


public Product(Long id, String name, String description, float price, List<CategoryProduct> categoriesProducts) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.price = price;
	this.categoriesProducts = categoriesProducts;
}


public Product(Long id, String name, String description, float price, Date createdAt, Date updatedAt,
		List<CategoryProduct> categoriesProducts) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.price = price;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	this.categoriesProducts = categoriesProducts;
}



}//end of Product
