package com.onlineclothing.demo.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineclothing.demo.entities.Categories;

@SpringBootTest
class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	public void testFindAllCategories() {
		List<Categories> categories = categoryRepository.findAll();
		categories.forEach(category -> System.out.println(category));
	}
	

}
