package com.cd.dtstanley.license.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="persons")
public class Persons {
	
	//Create Table
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Size(min=2, max=50)
	private String first_name;

	@Column
	@Size(min=2, max=50)
	private String last_name;
	
	@OneToOne(mappedBy="persons", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	 private Licenses licenses;
	
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
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
//	public Licenses getLicense() {
//		return license;
//	}
//	public void setLicense(Licenses license) {
//		this.license = license;
//	}
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
	
	//constructors
	public Persons() {
	}
//	public Persons(@Size(min = 2, max = 50) String first_name, @Size(min = 2, max = 50) String last_name,
//		Licenses license) {
//		this.first_name = first_name;
//		this.last_name = last_name;
//		this.license = license;
//	}
//	public Persons(Long id, @Size(min = 2, max = 50) String first_name, @Size(min = 2, max = 50) String last_name,
//		Licenses license) {
//		this.id = id;
//		this.first_name = first_name;
//		this.last_name = last_name;
//		this.license = license;
//	}
//	public Persons(Long id, @Size(min = 2, max = 50) String first_name, @Size(min = 2, max = 50) String last_name,
//			Licenses license, Date createdAt, Date updatedAt) {
//		this.id = id;
//		this.first_name = first_name;
//		this.last_name = last_name;
//		this.license = license;
//		this.createdAt = createdAt;
//		this.updatedAt = updatedAt;
//	}
	

	
	
}
