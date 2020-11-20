package com.cd.dtstanley.license.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd.dtstanley.license.models.Licenses;
import com.cd.dtstanley.license.models.Persons;
import com.cd.dtstanley.license.repositories.LicensesRepository;
//import com.cd.dtstanley.license.repositories.PersonsRepository;
import com.cd.dtstanley.license.repositories.PersonsRepository;



@Service
public class LicensesService {


    // adding the license repository as a dependency
//	   private final LicensesRepository licsRepository;
//	   private final PersonsRepository persRepository;
//	   
//	   //Injecting repositories into service
//	    public LicensesService(PersonsRepository persRepository, LicensesRepository licsRepository) {
//	        this.persRepository = persRepository;
//	        this.licsRepository = licsRepository;
//	    }
	
	
	@Autowired			//shortcut injection, replacing above
	private PersonsRepository persRepository;
	@Autowired
	private LicensesRepository licsRepository;
	    
	    // returns all the Persons
	    public List<Persons> allPersons() {//
	    	return persRepository.findAll();
	    }
	    
	    //add or create a person
	    public Persons addPerson(Persons peeps) {//
	    	return this.persRepository.save(peeps);
	    }
	    
	    //retrieves a person
	    public Persons findPerson(Long id) {//
	    	return this.persRepository.findById(id).orElse(null);
	    }

	    //find all unlicensed persons
	    public List<Persons> findAllUnlicensed(){//
	    	return this.persRepository.findByLicensesIdIsNull();
	    }
	    
	    //
	    public Licenses createLicense(Licenses lic) {
	    	System.out.println("Reached line 58 of LicensesService");
	    	lic.setNumber(this.generateLicNum());
	    	return this.licsRepository.save(lic);
	    }
	
	    
	    //Generate license number
	    public int generateLicNum() {
	    	System.out.println("Reached line 65 of LicensesService");
	    	Licenses lic = this.licsRepository.findTopByOrderByNumberDesc();
	    	System.out.println("Reached line 68 of LicensesService");
	    	if(lic== null)
	    	{
	    		return 0000001;
	    	}else {
	    		int highestNum = lic.getNumber();
	    		highestNum++;
	    		return highestNum;
	    	}
	    }
	    
	    
	
}// end of Service
