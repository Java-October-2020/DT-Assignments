package com.cd.dtstanley.prodandcat.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cd.dtstanley.prodandcat.models.Categories;
import com.cd.dtstanley.prodandcat.models.Products;
import com.cd.dtstanley.prodandcat.services.CategoriesService;
import com.cd.dtstanley.prodandcat.services.ProductsService;



@Controller
public class PandCHomeController {
	
	@Autowired
	private ProductsService prodSvc;
	@Autowired
	private CategoriesService catSvc;
	
//	@GetMapping("/")
//	public String index() {
//	return "/index.jsp";
//  }
	
	@GetMapping("/")
	public String index(Model viewModel) {
		viewModel.addAttribute("products", prodSvc.getAllProducts());
	return "/index.jsp";
	}
	
	@GetMapping("/products/new")
	public String newProd(@ModelAttribute("products") Products prod) {
		return "/products/newProd.jsp";
	}
	
	@GetMapping("/categories/new")
	public String newProd(@ModelAttribute("categories") Categories cat) {
		return "/categories/newCat.jsp";
	}
	
	@PostMapping("/products/new")
	public String addProd(@Valid @ModelAttribute("products") Products products, BindingResult result) {
		if(result.hasErrors()) {
			return "/products/newProd.jsp";
		}
		else {
			prodSvc.createProd(products);
			return "redirect:/products/new";
		}
	}
	
	@PostMapping("/categories/new")
	public String addCat(@Valid @ModelAttribute("categories") Categories categories, BindingResult result) {
		if(result.hasErrors()) {
			return "/categories/newCat.jsp";
		}
		else {
			catSvc.createCats(categories);
			return "redirect:/categories/new";
		}
	}
	
	@GetMapping("/products/{id}")
	public String showProd(@ModelAttribute()@PathVariable("id") Long id, Model viewModel, HttpSession session) {
		Products prod = this.prodSvc.findProductsById(id);
		viewModel.addAttribute("products", prod);
		List<Categories> uniqueCats = this.catSvc.catsNotAdded(prod);
			viewModel.addAttribute("uniqueCats", uniqueCats);
		List<Categories> categories = prod.getCategories();
//		viewModel.addAttribute("categories", categories);
//		Long userId = (Long)session.getAttribute("user_id");
//		User user = this.uService.findOneUser(userId);
//		viewModel.addAttribute("user", user);
		return "/products/showprod.jsp";
	}
	
	@GetMapping("/categories/{id}")
	public String showCat(@ModelAttribute()@PathVariable("id") Long id, Model viewModel, HttpSession session) {
		Categories cate = this.catSvc.findCategoriesById(id);
		viewModel.addAttribute("categories", cate);
		List<Products> products = cate.getProducts();
		viewModel.addAttribute("products", products);
		List<Products> unAddedProds = this.prodSvc.getUniqueCat(cate);
		viewModel.addAttribute("unAddedProds", unAddedProds);
		System.out.println("ID: " + cate.getId() + " & " + cate.getProducts());
		return "/categories/showcat.jsp";
	}

	@PostMapping("/products/addCategories/{id}")
	public String addCats(@PathVariable("id") Long id, @RequestParam("categories") Long catId) {
		System.out.println("Category ID: " + catId);
		System.out.println("Line 104 of PandCHomeController reached, trying to post catg to prod.");
		Long productsId = id;
		Categories catgs = this.catSvc.findCategoriesById(catId);
		Products prodOfCatgsToAdd = this.prodSvc.findProductsById(productsId);
		this.prodSvc.addProductToCatg(prodOfCatgsToAdd, catgs);
		return "redirect:/products/" + id;
	}
	
	
}//end of Controller
