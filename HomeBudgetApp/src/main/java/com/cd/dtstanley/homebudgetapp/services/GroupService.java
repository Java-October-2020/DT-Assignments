package com.cd.dtstanley.homebudgetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd.dtstanley.homebudgetapp.models.Groupset;
import com.cd.dtstanley.homebudgetapp.repositories.GroupRepository;

@Service
public class GroupService {

		@Autowired
		private GroupRepository groupRepo;

		
		// Get All Groups
		public List<Groupset> getAllGroups(){
			return this.groupRepo.findAll();
		}
		
		// Get One Group
			public Groupset getSingleGroup(Long id) {
				return this.groupRepo.findById(id).orElse(null);
			}
			
			// Create A Group
			public Groupset createGroup(Groupset newGroup) {
				return this.groupRepo.save(newGroup);
			}
			
			// Build the Group created
			public Groupset buildGroup(Groupset crtdGroup) {
				return this.groupRepo.save(crtdGroup);
			}
			
			// Delete A Group
			public void deleteGroup(Long id) {
				this.groupRepo.deleteById(id);
			}
			
			// Update a Group
			public Groupset updateGroup(Groupset group) {
				return this.groupRepo.save(group);
			}
	
}//end of GrpSvc
