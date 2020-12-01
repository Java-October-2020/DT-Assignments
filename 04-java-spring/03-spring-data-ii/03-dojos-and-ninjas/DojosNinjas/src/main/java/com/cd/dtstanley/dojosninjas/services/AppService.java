package com.cd.dtstanley.dojosninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd.dtstanley.dojosninjas.models.Dojo;
import com.cd.dtstanley.dojosninjas.models.Ninja;
import com.cd.dtstanley.dojosninjas.repositories.DojoRepository;
import com.cd.dtstanley.dojosninjas.repositories.NinjaRepository;


@Service
public class AppService {

@Autowired 		//shortcut injection, replacing above
private DojoRepository dojoRepo;

@Autowired		//shortcut injection, replacing above
private NinjaRepository ninjaRepo;

public AppService() {
	
}
    
    // returns all the Dojos
    public List<Dojo> allDojos() {
    	return dojoRepo.findAll();
    }
    
    //add or create a Dojo
    public Dojo addDojo(Dojo myDojo) {
    	return this.dojoRepo.save(myDojo);
    }
    
    //retrieves a Dojo
    public Dojo findDojo(Long id) {
    	return this.dojoRepo.findById(id).orElse(null);
    }
    
    //add or create a Ninja
    public Ninja addNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
    
 // returns all the Ninjas
    public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
    
    //retrieves a Ninja
    public Ninja findNinja(Long id) {
    	return this.ninjaRepo.findById(id).orElse(null);
    }
    
//    //Add User Who Likes the Dojo
//    public void addLiker(User user, GreatIdea gidea) {
//    	//Get the list of likers from the greatidea
//    	List<User> likers = gidea.getLikers();
//    	//Add the liker
//    	likers.add(user);
//    	//Update database
//    	this.ideaRepo.save(gidea);
//    }
//    
//    //update a idea by calling a service
//    public GreatIdea updateIdea(GreatIdea updIdea) {
//    	return ideaRepo.save(updIdea);
//    	}
	
}//end of appService



