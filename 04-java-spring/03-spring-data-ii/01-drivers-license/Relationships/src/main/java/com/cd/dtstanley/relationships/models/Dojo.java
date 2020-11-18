package com.cd.dtstanley.relationships.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dojos")
public class Dojo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    @Size(min=2, max=50)
    private String name;

    @Column
    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    private List<Ninja> ninjas;
    
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


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
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


public List<Ninja> getNinjas() {
	return ninjas;
}


public void setNinjas(List<Ninja> ninjas) {
	this.ninjas = ninjas;
}


public Dojo() {
    
}


public Dojo(String name, List<Ninja> ninjas) {
	this.name = name;
	this.ninjas = ninjas;
}


public Dojo(Long id, String name, List<Ninja> ninjas) {
	this.id = id;
	this.name = name;
	this.ninjas = ninjas;
}


public Dojo(Long id, String name, Date createdAt, Date updatedAt, List<Ninja> ninjas) {
	this.id = id;
	this.name = name;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	this.ninjas = ninjas;
}





}//end of Dojo
