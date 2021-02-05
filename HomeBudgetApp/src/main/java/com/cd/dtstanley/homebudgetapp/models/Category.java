package com.cd.dtstanley.homebudgetapp.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private BigDecimal budget;
    
	@Size(min=1, max=30, message="The size was too big or too small")
	private String categoryName;
	
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date startDate;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date endDate;
    
	private Date updatedAt;

	private Date createdAt;
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
	//Relationship Many-To-One with Category
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="category_id")
	private Groupset group;			//Should this be private List<Groupset> group?
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY, mappedBy="category")
	private List<Transaction> transaction;
//	private Set<Transaction> transaction = new TreeSet<>();   //treeset rather than hashset because it provides ordering
	
	
	//Getters and Setters
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

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getBudget() {
		return budget;
	}
	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
	

	public Groupset getGroup() {
		return group;
	}
	public void setGroup(Groupset group) {
		this.group = group;
	}
	
	public List<Transaction> getTransaction() {
		return transaction;
	}
	
	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	    
	    
	    //Constructor
		public Category() {
		}
	
	
}//end of Category

