package com.onlineclothing.demo.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineclothing.demo.entities.Products;

@SpringBootTest
class ProductRepositoryTest {
	
	@Autowired
	private ProductRepository productRepository;

	@Test
	public void testFindAllProducts() {
		List<Products> products = productRepository.findAll();
		products.forEach(product -> System.out.println(product));
	}
	
	@Test
	public void testFindByCategoryid() {
		List<Products> products = productRepository.findByCategoryid(2);
		products.forEach(product -> System.out.println(product));
	}

	@Test
	public void repositoryNotEmptyTest() {
		List<Products> products = productRepository.findAll();
		assertThat(products).isNotEmpty();
	}

	@Test
	public void findAllByNameTest() {
		List<Products> products = productRepository.findAllByName("Women");
		System.out.println(products);
		assertNotNull(products);
	}
	
	@Test
	public void findAllTest() {
		List<Products> products = productRepository.findAll();
		System.out.println(products);
		
	}
	
	@Test
	public void findAllByGenderTest() 
	{
		List<Products> products = productRepository.findAllByGender("Men");
		assertEquals("Men",products.get(0).getCategory().getCategoryGender());
	}
	
}
