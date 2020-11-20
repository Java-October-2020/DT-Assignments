package com.cd.dtstanley.license.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="licenses")
public class Licenses {

	// Create Table
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	//@Size(min=5, max=20)
	private int number;
	
	@Column
	@Size(min=2, max=30)
	private String state;
		
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")   //This pattern is required for input when passing data parameters in Spring MVC
	private Date expiration_date;
	
	 @OneToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="persons_id")
	 private Persons persons;
	
	
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
    
    
    //getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}
	public Persons getPersons() {
		return persons;
	}
	public void setPersons(Persons persons) {
		this.persons = persons;
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
	
	
	public Licenses() {
			}
	
	public Licenses(@Size(min = 5, max = 20) int number, @Size(min = 2, max = 30) String state, Date expiration_date,
			Persons person) {
		this.number = number;
		this.state = state;
		this.expiration_date = expiration_date;
		this.persons = person;
	}
	public Licenses(Long id, @Size(min = 5, max = 20) int number, @Size(min = 2, max = 30) String state,
			Date expiration_date, Persons person) {
		this.id = id;
		this.number = number;
		this.state = state;
		this.expiration_date = expiration_date;
		this.persons = person;
	}
	public Licenses(Long id, @Size(min = 5, max = 20) int number, @Size(min = 2, max = 30) String state,
			Date expiration_date, Persons person, Date createdAt, Date updatedAt) {
			this.id = id;
		this.number = number;
		this.state = state;
		this.expiration_date = expiration_date;
		this.persons = person;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
    //converting a license number from int to string and creating format
	//could not have used a random number creator
    public String getNumberAsString() {
    	int numZeros = 7 - String.valueOf(this.number).length();
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; 1< numZeros; i++)
    		sb.append('0');
    	return String.format("%s%d", sb, this.number);
    }
	
    
}
