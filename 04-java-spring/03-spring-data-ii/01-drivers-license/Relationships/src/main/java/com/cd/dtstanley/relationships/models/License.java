package com.cd.dtstanley.relationships.models;

import java.util.Date;

import javax.persistence.CascadeType;
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
public class License {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    @Size(min=2, max=20)
    private String number;
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date expiration_date;
    
    @Column
    @Size(min=2, max=15)
    private String state;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;

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


public String getNumber() {
	return number;
}


public void setNumber(String number) {
	this.number = number;
}


public Date getExpiration_date() {
	return expiration_date;
}


public void setExpiration_date(Date expiration_date) {
	this.expiration_date = expiration_date;
}


public String getState() {
	return state;
}


public void setState(String state) {
	this.state = state;
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


public Person getPerson() {
	return person;
}


public void setPerson(Person person) {
	this.person = person;
}
   
public License() {
    
}


public License(String number, Date expiration_date, String state, Person person) {
	this.number = number;
	this.expiration_date = expiration_date;
	this.state = state;
	this.person = person;
}


public License(Long id, String number, Date expiration_date, String state, Person person) {
	this.id = id;
	this.number = number;
	this.expiration_date = expiration_date;
	this.state = state;
	this.person = person;
}


public License(Long id, String number, Date expiration_date, String state, Date createdAt, Date updatedAt,
		Person person) {
	this.id = id;
	this.number = number;
	this.expiration_date = expiration_date;
	this.state = state;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	this.person = person;
}




}
