package com.cd.dtstanley.homebudgetapp.models;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	    
//	    //treeset rather than hashset because it provides ordering
//		@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="user")
//	    private Set<Groupset> groups = new TreeSet<>();	//set collection removes duplicates	 
	    
		//treeset rather than hashset because it provides ordering
		//Relationship Many-To-Many with Budget if what to share budgets between users
		@ManyToMany(fetch=FetchType.LAZY)
		@JoinTable(
				name="users_budgets",
				joinColumns = @JoinColumn(name="user_id"),
				inverseJoinColumns = @JoinColumn(name="budget_id")
				)	    
		private Set<Budget> budgets = new TreeSet<>();	//set collection removes duplicates	 

	    
	    // NEW
	    @Size(min=8, message="Password must be greater than 7 characters")
	    private String password;
	    
	    @Transient
	    private String passwordConfirmation;
		public Long getId() {
			return id;
		}
		
		//getters and setters
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
		
//		public Set<Groupset> getGroups() {
//			return groups;
//		}
//
//		public void setGroups(Set<Groupset> groups) {
//			this.groups = groups;
//		}
//		
		public Set<Budget> getBudgets() {
		return budgets;
	}

	public void setBudgets(Set<Budget> budgets) {
		this.budgets = budgets;
	}


		//Constructors
		public User() {
		}

	
}//end of User
