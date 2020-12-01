package com.cd.dtstanley.authentication.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(min=2, max=25)
    private String firstName;
    
    @NotBlank
    @Size(min=2, max=25)
    private String lastName;
    
    @Email
    @NotBlank
    private String email;

    // NEW
    @Size(min=5, message="Password must be greater than 5 characters")
    private String password;
    @Transient
    private String passwordConfirmation;
    
//    @Column(updatable=false)
//    private Date createdAt;
//    private Date updatedAt;
    

    
//    @PrePersist
//    protected void onCreate(){
//        this.createdAt = new Date();
//    }
//    @PreUpdate
//    protected void onUpdate(){
//        this.updatedAt = new Date();
//    }
    
    //getters and setters
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	
//	public Date getCreatedAt() {
//		return createdAt;
//	}
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}
//	public Date getUpdatedAt() {
//		return updatedAt;
//	}
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}
	
	
	
	
	//constructors
	public User() {
    }
	
	public User(String email, String password, String passwordConfirmation) {
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
	}
	
	
	public User(Long id, String email, String password, String passwordConfirmation) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
	}
	public User(@NotBlank @Size(min = 2, max = 25) String firstName, @NotBlank @Size(min = 2, max = 25) String lastName,
			@Email @NotBlank String email,
			@Size(min = 5, message = "Password must be greater than 5 characters") String password,
			String passwordConfirmation) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
	}
	public User(Long id, @NotBlank @Size(min = 2, max = 25) String firstName,
			@NotBlank @Size(min = 2, max = 25) String lastName, @Email @NotBlank String email,
			@Size(min = 5, message = "Password must be greater than 5 characters") String password,
			String passwordConfirmation) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
	}
    

//	public User(Long id, String email, String password, String passwordConfirmation, Date createdAt, Date updatedAt) {
//		this.id = id;
//		this.email = email;
//		this.password = password;
//		this.passwordConfirmation = passwordConfirmation;
//		this.createdAt = createdAt;
//		this.updatedAt = updatedAt;
//	}
	
    
}// end of User