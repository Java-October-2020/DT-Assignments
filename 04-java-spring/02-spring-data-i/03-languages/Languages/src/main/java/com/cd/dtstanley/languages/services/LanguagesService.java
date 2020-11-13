package com.cd.dtstanley.languages.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.cd.dtstanley.languages.models.Languages;
import com.cd.dtstanley.languages.repositories.LanguagesRepository;


@Service
	public class LanguagesService {
	    // adding the book repository as a dependency
	   private final LanguagesRepository languagesRepository;
	   
	    public LanguagesService(LanguagesRepository languagesRepository) {
	        this.languagesRepository = languagesRepository;
	    }
	    
	    
	    // returns all the languages
	    public List<Languages> allLanguages() {
	        return languagesRepository.findAll();
	    }
	    // creates a Language
	    public Languages createLang(Languages languages) {
	        return (Languages) languagesRepository.save(languages);
	 //       return this.languagesRepository.save(lang);
	    }
	    
	   // retrieves a user
//	    public Languages findLang(Long id) {
//	        Optional<Languages> optionalLang = languagesRepository.findById(id);
//	        if(optionalLang.isPresent()) {
//	            return optionalLang.get();
//	        } else {
//	            return null;
//	        }
//	    }
//	    public List<Languages> allLanguages() {
//	        return lang;
//	    }
	    
	    // retrieves a user
	    public Languages findLanguagesByIndex(Long index) {
//	        if (index < languages.size()){
//	            return languages.get(index);
	    	Optional<Languages> optionalLang = languagesRepository.findById(index);
	    	if(optionalLang.isPresent()) {
	    		return optionalLang.get();
	        }else{
	            return null;
	        }
	    }
	    
	    //update a user by calling a service
	    public Languages updateLang(Languages updLang) {
	    	return languagesRepository.save(updLang);
	    	}
	    
	    //delete a user by calling a service
	    public String deleteLang(Long id) {
	    	languagesRepository.deleteById(id);
	    	return "Languages ID: " + id + "has been deleted.";
	    }

	}//end of LanguagesService
