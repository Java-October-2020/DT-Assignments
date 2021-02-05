package com.cd.dtstanley.homebudgetapp.models;

import java.math.BigDecimal;
import java.util.Date;

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
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
 //   @DateTimeFormat(pattern = "MM-dd-YYYY")
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    private Date effectiveDate;
    
	private BigDecimal amount;
	
	@Size(min=1, max=30, message="The size was too big or too small")
	private String transactionType;
	
	@Size(max=150, message="That was too many words")
	private String transactionName;
	
	private BigDecimal projectedCost;
	
	private BigDecimal actualCost;


	private Date updatedAt;

	private Date createdAt;
	
	//Relationship Many-To-One with Transaction
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="transaction_id")
	private Category category;
	
	

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
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String gettransactionName() {
		return transactionName;
	}
	public void settransactionName(String transactionName) {
		this.transactionName = transactionName;
	}
	

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public BigDecimal getProjectedCost() {
		return projectedCost;
	}
	public void setProjectedCost(BigDecimal projectedCost) {
		this.projectedCost = projectedCost;
	}
	public BigDecimal getActualCost() {
		return actualCost;
	}
	public void setActualCost(BigDecimal actualCost) {
		this.actualCost = actualCost;
	}
	
	
	
	@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    
	    //Constructor
		public Transaction() {
		}
	    
}//end of Transaction
