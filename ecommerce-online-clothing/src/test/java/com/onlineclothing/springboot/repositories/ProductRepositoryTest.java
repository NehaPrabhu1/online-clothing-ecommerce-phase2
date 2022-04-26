package com.onlineclothing.springboot.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.onlineclothing.springboot.entities.Products;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductRepositoryTest {
	@Autowired
	ProductRepository productRepository;

	@Test
	void findAllByNameTest() {
		List<Products> products = productRepository.findAllByName("Women");
		assertEquals(8, products.size());
	}
	
	@Test
	void findAllTest() {
		List<Products> products = productRepository.findAll();
		assertEquals(16, products.size());
		
	}

}
