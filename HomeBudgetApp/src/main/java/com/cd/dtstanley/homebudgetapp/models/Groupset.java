package com.cd.dtstanley.homebudgetapp.models;



import java.util.Date;
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

@Entity
	@Table(name="groupset")
	public class Groupset {
	
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id;
	    
 
		@Size(min=1, max=30, message="The size was too big or too small")
		private String groupName;

		@Size(min=1, max=200, message="The size was too big or too small")
		private String description;

		//Relationship Many-To-One with GroupSet
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="budget_id")		
		private Budget budget;

//		//Not sure if I need this MToO anymore?
//		//Relationship Many-To-One with GroupSet
//		@ManyToOne(fetch=FetchType.LAZY)
//		@JoinColumn(name="user_id")
//		private User user;
//		
		@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY, mappedBy="group")
		private List<Category> categories;
//		private Set<Category> categories = new TreeSet<>();  //treeset rather than hashset because it provides ordering
		
		
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

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
		    
			public Long getId() {
				return id;
			}
			public void setId(Long id) {
				this.id = id;
			}
			public String getGroupName() {
				return groupName;
			}
			public void setGroupName(String groupName) {
				this.groupName = groupName;
			}
			public String getDescription() {
				return description;
			}
			public void setDescription(String description) {
				this.description = description;
			}
			

//			public User getUser() {
//				return user;
//			}
//
//			public void setUser(User user) {
//				this.user = user;
//			}
			
			public List<Category> getCategories() {
				return categories;
			}

			public void setCategories(List<Category> categories) {
				this.categories = categories;
			}


			public Budget getBudget() {
				return budget;
			}

			public void setBudget(Budget budget) {
				this.budget = budget;
			}

			//Constructor
			public Groupset() {
		
			}
		
		
	}//end of Groupset
