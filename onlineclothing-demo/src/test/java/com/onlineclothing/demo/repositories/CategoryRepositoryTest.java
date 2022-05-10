package com.onlineclothing.demo.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

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
	
	@Test
	void testFindById() {
		int id = 2;
		Optional<Categories> optional = categoryRepository.findById(id);
		System.out.println(optional.get());
	}
	
	@Test
	void testCategoryCount() {
		long count = categoryRepository.count();
		System.out.println(count);
	}
	

}
