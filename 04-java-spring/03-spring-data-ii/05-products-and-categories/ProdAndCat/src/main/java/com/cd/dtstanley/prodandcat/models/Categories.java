package com.cd.dtstanley.prodandcat.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="categories")
public class Categories {

	
	// Create Table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
    private Long id;

//    @Column
//    @Size(min=2, max=30)
	private String name;
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;
//    @Column
//    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
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
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
    		name = "prodcat",
    		joinColumns = @JoinColumn(name = "categories_id"),	//Had to enter JoinColumn import manually
    		inverseJoinColumns = @JoinColumn(name = "products_id")
    		) 
//    @OneToMany(mappedBy= "categories", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<Associated> associated;
    private List<Products> products;
    
    //getters and setters
    
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
	
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}
	
	
	//Constructors
	public Categories() {
	}
	public Categories(@Size(min = 2, max = 30) String name) {
		this.name = name;
	}
	public Categories(Long id, @Size(min = 2, max = 30) String name) {
		this.id = id;
		this.name = name;
	}
	public Categories(Long id, @Size(min = 2, max = 30) String name, Date createdAt, Date updatedAt) {
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
    
    
	
}//end of Categories
