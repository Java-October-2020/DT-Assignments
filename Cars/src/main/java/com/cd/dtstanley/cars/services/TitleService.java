package com.cd.dtstanley.cars.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd.dtstanley.cars.models.Title;
import com.cd.dtstanley.cars.repositories.TitleRepository;

@Service
public class TitleService {
	@Autowired
	private TitleRepository tRepo;
	
	//Create
	public Title create(Title title) {
		return this.tRepo.save(title);
	}
}

