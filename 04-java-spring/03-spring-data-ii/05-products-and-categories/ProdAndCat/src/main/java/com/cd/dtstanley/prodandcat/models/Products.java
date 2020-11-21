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
@Table(name="products")
public class Products {

	// Create Table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
//    @Column
//    @Size(min=2, max=30)
	private String name;
    
//    @Column
//    @Size(max=50)
	private String description;
    
//    @Column
//    @Size(max=20)
	private Double price;
    
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
    		//Whichever table we are presently on is first identified for JoinColumn
    		joinColumns = @JoinColumn(name = "products_id"),	//Had to enter JoinColumn import manually
    		inverseJoinColumns = @JoinColumn(name = "categories_id")
    		) 

    private List<Categories> categories;	//List of categories to which this product is going to belong

    
//    @OneToMany(mappedBy="products", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<Associated> associated;
    
    
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
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
	
	public List<Categories> getCategories() {
		return categories;
	}
	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}
	
	
	//Constructors
	public Products() {
	}
	public Products(@Size(min = 2, max = 30) String name, @Size(max = 50) String description,
			@Size(max = 20) Double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public Products(Long id, @Size(min = 2, max = 30) String name, @Size(max = 50) String description,
			@Size(max = 20) Double price, Date createdAt, Date updatedAt) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Products(Long id, @Size(min = 2, max = 30) String name, @Size(max = 50) String description,
			@Size(max = 20) Double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
    
	
	
}// end of Products
