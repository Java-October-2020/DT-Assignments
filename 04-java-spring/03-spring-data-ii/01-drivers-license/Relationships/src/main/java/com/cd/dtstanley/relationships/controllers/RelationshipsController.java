package com.cd.dtstanley.relationships.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RelationshipsController {

//	 private final RelaService relaService;
	    
//	    //public Relationships(RelaService relaService)
//	    public RelationshipsController(RelaService relaService) {
//	        this.relaService = relaService;
//	    }
	    
	    @RequestMapping("/")
	    public String start(Model viewModel) {
	    return "redirect:/relationships";
	    }	
	
	
}//end of RelationshipsController
