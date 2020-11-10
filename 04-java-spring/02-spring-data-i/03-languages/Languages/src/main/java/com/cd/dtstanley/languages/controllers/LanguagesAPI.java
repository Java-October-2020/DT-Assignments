package com.cd.dtstanley.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cd.dtstanley.languages.models.Languages;
import com.cd.dtstanley.languages.services.LanguagesService;

@RestController
	public class LanguagesAPI {
	    private LanguagesService languagesService;
	    public LanguagesAPI(LanguagesService languagesService){
	        this.languagesService = languagesService;
	    }
	    
	    public LanguagesAPI() {
	    	
	    }
	    
//	    @RequestMapping("/api/languages")
//	    public String index() {
//	        return languagesService.allLanguages();
//	    }
	    
	    @RequestMapping(value="/api/languages", method=RequestMethod.POST)
	    public Languages create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="vers") Float currentVersion) {
	    	Languages languages = new Languages(name, creator, currentVersion );
	        return languagesService.createLang((List<Languages>) languages);
	    }
	    
	    @RequestMapping("/api/languages/{id}")
	    public Languages show(@PathVariable("id") Long id) {
	    	Languages languages = languagesService.findLanguagesByIndex(id);
	        return languages;
	    }
	}
