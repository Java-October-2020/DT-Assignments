package com.cd.dtstanley.dojosurvey.model;

public class Survey {
	private String name; 
	private String location; 
	private String language; 
	private String comment;

	public Survey() {
	
	}
	
	public Survey(String name, String location, String language, String comment) {
		this.name = name;
		this.location = location;
		this.language = language;
		this.comment = comment;
	}

	//getters
	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public String getLanguage() {
		return language;
	}

	public String getComment() {
		return comment;
	}
	
	//setters
	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
