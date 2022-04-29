package com.onlineclothing.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineclothing.springboot.entities.Categories;
import com.onlineclothing.springboot.entities.Products;
import com.onlineclothing.springboot.repositories.CategoryRepository;


@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Categories> findAllCategories(){
		return categoryRepository.findAll();
	}
	
	public List<Products> findProductsByCategory(Integer categoryid){
		List<Products> products = null;
		Optional<Categories> optional = categoryRepository.findById(categoryid);
		if(optional.isPresent()) {
			Categories category = optional.get();
			products = category.getProducts();
		}
		return products;
	}
	
	public long getCategoriesCount() {
    	return categoryRepository.count();
    }

}
