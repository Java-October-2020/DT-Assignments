package com.cd.dtstanley.dojocontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class DojoControllerApplication {
	String route;
	public static void main(String[] args) {
		SpringApplication.run(DojoControllerApplication.class, args);
	}

	   @RequestMapping("/dojo")
	    public String showDojo() {
		   		return "The dojo is awesome";
		}
	
	   @RequestMapping("/dojo/{route}") 
	    public String showProduct(@PathVariable ("route") String route){
		   if(route.equals("burbank")) {
			   return "Burbank Dojo is located in Southern California.";
		   }else if (route.equals("san-jose")) {
			   return "SJ dojo is the headquarters.";
		   }else {
			   return "The dojo is awesome";
		   }
	   }
}
