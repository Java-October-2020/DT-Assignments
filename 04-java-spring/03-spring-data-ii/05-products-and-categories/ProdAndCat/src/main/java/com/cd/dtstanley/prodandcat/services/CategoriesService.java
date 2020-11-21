package com.cd.dtstanley.prodandcat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd.dtstanley.prodandcat.models.Categories;
import com.cd.dtstanley.prodandcat.models.Products;
import com.cd.dtstanley.prodandcat.repositories.CategoriesRepository;

@Service
public class CategoriesService {

	@Autowired
	private CategoriesRepository catRepo;
	
	//Get All
	public List<Categories> getAllCategories(){
		return this.catRepo.findAll();
	}
	
	//Create  or update Categories
	public Categories createCats(Categories categories) {
		return this.catRepo.save(categories);
	}
	
	//Get One Categories
	public Categories findCategoriesById(Long id) {
		return this.catRepo.findById(id).orElse(null);
	}
	
	public List<Categories> catsNotAdded(Products products){
		return this.catRepo.findByProductsNotContains(products);
	}
	
//	public List<Categories> 
	
}//end of CatRepo
