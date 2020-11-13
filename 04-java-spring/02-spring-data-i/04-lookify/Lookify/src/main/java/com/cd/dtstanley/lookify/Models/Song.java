package com.cd.dtstanley.lookify.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="songs")
public class Song {

	// Create Table
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Size(min=5, max=50)
	private String title;
	
	@Column
	@Size(min=5)
	private String artist;
	
	@Column
	@Min(1)
	@Max(10)
	private int rating;
	
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
	
    
  //getters
    
    public Long getId() {
    	return id;
    }
    
    public String getTitle() {
		return title;
	}
    
    public String getArtist() {
		return artist;
	}
    
    public int getRating() {
		return rating;
	}
    
    public Date getCreatedAt() {
		return createdAt;
	}
    
    public Date getUpdatedAt() {
		return updatedAt;
	}
    
  //setters
    
    public void setId(Long id) {
    	this.id=id;
    	
    }
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
	public Song() {
		
	}
	public Song(@Size(min = 5, max = 50) String title, @Size(min = 5) String artist, @Min(1) @Max(10) int rating) {
		this.title = title;
		this.artist = artist;
		this.rating = rating;
	}
	
	public Song(Long id, @Size(min = 5, max = 50) String title, @Size(min = 5) String artist,
			@Min(1) @Max(10) int rating) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.rating = rating;
	}
	public Song(Long id, @Size(min = 5, max = 50) String title, @Size(min = 5) String artist,
			@Min(1) @Max(10) int rating, Date createdAt, Date updatedAt) {
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.rating = rating;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Song(@Size(min = 5, max = 50) String title, @Size(min = 5) String artist, @Min(1) @Max(10) int rating,
			Date createdAt, Date updatedAt) {
		this.title = title;
		this.artist = artist;
		this.rating = rating;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	
	
    
}//end of Song class
