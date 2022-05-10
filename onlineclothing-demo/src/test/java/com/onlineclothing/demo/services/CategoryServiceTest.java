package com.onlineclothing.demo.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineclothing.demo.entities.Categories;
import com.onlineclothing.demo.entities.Products;

@SpringBootTest
class CategoryServiceTest {
	
	@Autowired
	CategoryService categoryService;

	@Test
	void getCategoriesCount() {
		Long category = categoryService.getCategoriesCount();
		System.out.println(category);
	}
	
	@Test 
	void testFindAllCategories(){
		List<Categories> allCategories = categoryService.findAllCategories();
		System.out.println(allCategories);
		assertNotNull(allCategories);
	}
	
	@Test
	void testFindProductsByCategory() {
		List<Products> products = categoryService.findProductsByCategory(2);
		if(!products.isEmpty()) {
			assertEquals(2, products.get(0).getCategoryid());
		}
		else {
			assertNull(products);
		}
	}
	
	
	
	
	
	

}
