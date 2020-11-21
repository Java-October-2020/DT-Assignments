package com.cd.dtstanley.prodandcat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd.dtstanley.prodandcat.models.Categories;
import com.cd.dtstanley.prodandcat.models.Products;
import com.cd.dtstanley.prodandcat.repositories.ProductsRepository;
@Service
public class ProductsService {
	
	@Autowired
	private ProductsRepository prodRepo;
	
	//Get All Products
	public List<Products> getAllProducts(){
		return this.prodRepo.findAll();
	}
	
	//Create  or update Products
	public Products createProd(Products products) {
		return this.prodRepo.save(products);
	}
	
	//Get One Products
	public Products findProductsById(Long id) {
		return this.prodRepo.findById(id).orElse(null);
	}
	
	// Get Unique Categories
	public List<Products> getUniqueCat(Categories categories){
		return this.prodRepo.findByCategoriesNotContains(categories);
	}
	
	
	// Add Product To Category
		public void addProductToCatg(Products product, Categories category) {
			System.out.println("Line 40 of ProductsService has been reached - add product to category");
			// Get The List From the Product Object
			System.out.println("Line 42 of ProductsService has been reached - add product to category");
			List<Categories> cats = product.getCategories();
			// Add The Category
			System.out.println("Line 44 of ProductsService has been reached - add product to category");
			cats.add(category);
			System.out.println("Cat ID: " + category.getId() + "  Product ID: " + product.getId());
			// Update database
			System.out.println("Line 48 of ProductsService has been reached - add product to category");
			this.prodRepo.save(product);
			System.out.println("Line 50 of ProductsService has been reached - add product to category");
		}
		

}
