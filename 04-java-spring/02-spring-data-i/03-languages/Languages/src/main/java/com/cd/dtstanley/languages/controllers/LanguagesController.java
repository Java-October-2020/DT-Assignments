package com.cd.dtstanley.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cd.dtstanley.languages.models.Languages;
import com.cd.dtstanley.languages.services.LanguagesService;

@Controller
	public class LanguagesController {		

	@Autowired		//injecting our service thru a shortcut process
	private LanguagesService languagesService;	//injecting our service 
	    

	@RequestMapping("/")
    public String start(Model viewModel, @ModelAttribute("languages") Languages languages ) {
		List<Languages> lang = this.languagesService.allLanguages();
		viewModel.addAttribute("languages", lang);
//		System.out.println("controller output: " + this.languagesService.allLanguages());
//    return "redirect:/languages/new";
//    return "/languages/newLang.jsp";
    return "/languages/index.jsp";
	}
	
    @RequestMapping("/languages/new")			//show them the form to create the book
    public String newLang(@ModelAttribute("languages") Languages languages) {
    	return "/languages/newLang.jsp";
    }
    
    @RequestMapping("/languages/{id}")
    public String present(@PathVariable("id") Long id, Model viewModel) {
    	viewModel.addAttribute("languages", this.languagesService.findLanguagesByIndex(id));
    	return "/languages/showUser.jsp";
    }
    
    // add new language
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String createLang(@Valid @ModelAttribute("languages") Languages languages, BindingResult result) {
		if (result.hasErrors()) {
			return "/languages/new.jsp";
		}else {
			languagesService.createLang(languages);
    	return "redirect:/";
		}
    }
	//show one language
    @RequestMapping("/showUser/{id}")
    public String pres(@PathVariable("id") Long id, Model viewModel) {
    	viewModel.addAttribute("languages", this.languagesService.findLanguagesByIndex(id));
    	return "/languages/showUser.jsp";
    }

	    @RequestMapping("/languages")		//show them all the users
	    public String index(Model viewModel) {
	        List<Languages> languages = languagesService.allLanguages();
	        viewModel.addAttribute("languages", languages);
	        return "/languages/show.jsp";
	    }
	    
	    
       // retrieve the data to be edit and then posted - an @PostMapping must follow)
        @GetMapping("/edit/{id}")
	//   @RequestMapping(value = "/edit", method= {RequestMethod.GET, RequestMethod.POST})

	        public String updateLang(@ModelAttribute("languages") Languages languages, @PathVariable("id") Long id, Model viewModel) {
          	Languages lang = this.languagesService.findLanguagesByIndex(id);
	    	System.out.println("id= " + id + " or " + lang.getId());        		viewModel.addAttribute("languages", lang);
    		 return "/languages/edit.jsp";
      // 	 }
        }
	  
      //creating post mapping that posts the languages detail into the database (after the Edit's submit button is pushed)  
        @PostMapping("/edit/{id}")
        public String updLang(@Valid @ModelAttribute("languages") Languages languages, BindingResult result) {
       	  if(result.hasErrors()) {
			  System.out.println("There is an error in the create method due validations in Languages class.");
			  return "/languages/edit.jsp";
		  }else {
				   
			  this.languagesService.updateLang(languages);
		  return "redirect:/";  //redirect from a postMapping, because we do not want to render
		  }
}
        //Retrieve and delete from database

        @GetMapping("/delete/{id}")
        public String langDelete(@PathVariable("id") Long id) {
        	this.languagesService.deleteLang(id);
        	System.out.println("Language/User Deleted");
        	return "redirect:/";
        }

   	 
	}//end of LanguagesController
