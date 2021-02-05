package com.cd.dtstanley.homebudgetapp.models;

import java.math.BigDecimal;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="budget")
public class Budget {		

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;	
    
	@Size(min=1, max=30, message="The size was too big or too small")
    private String budgetName;
    
    @DateTimeFormat(pattern = "YYYY")
	private Date year;
    
    @DateTimeFormat(pattern = "MM")
	private Date month;
//	private BigDecimal total;
	private BigDecimal projectedTotal;
	private BigDecimal actualTotal;
//	private BigDecimal totalDifference;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="budget" )
	private List<Groupset> groups;
//	private Set<Groupset> groups = new TreeSet<>();

	
	//Relationship Many-To-Many with Budget if what to share budgets between users
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="users_budgets",
			joinColumns = @JoinColumn(name="budget_id"),
			inverseJoinColumns = @JoinColumn(name="user_id")
			)
	private List<User> users;
//	private Set<User> users = new TreeSet<>();
	

	//Discovered that these lines must be in close proximity to work properly
	private Date createdAt;
	private Date updatedAt;
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
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBudgetName() {
		return budgetName;
	}
	public void setBudgetName(String budgetName) {
		this.budgetName = budgetName;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	public Date getMonth() {
		return month;
	}
	public void setMonth(Date month) {
		this.month = month;
	}
	public BigDecimal getProjectedTotal() {
		return projectedTotal;
	}
	public void setProjectedTotal(BigDecimal projectedTotal) {
		this.projectedTotal = projectedTotal;
	}
	public BigDecimal getActualTotal() {
		return actualTotal;
	}
	public void setActualTotal(BigDecimal actualTotal) {
		this.actualTotal = actualTotal;
	}
	

	public List<Groupset> getGroups() {
		return groups;
	}
	public void setGroups(List<Groupset> groups) {
		this.groups = groups;
	}
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	

	    
	    
	    //Constructor
		public Budget() {
		}
	    
}//end of Budget
