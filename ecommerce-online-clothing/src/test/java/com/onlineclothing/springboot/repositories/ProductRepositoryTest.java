package com.onlineclothing.springboot.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.onlineclothing.springboot.entities.Products;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductRepositoryTest {
	@Autowired
	ProductRepository productRepository;

	@Test
	public void repositoryNotEmptyTest() {
		List<Products> products = productRepository.findAll();
		assertThat(products).isNotEmpty();
	}

	@Test
	public void findAllByNameTest() {
		List<Products> products = productRepository.findAllByName("Women");
		assertEquals(8, products.size());
	}
	
	@Test
	public void findAllTest() {
		List<Products> products = productRepository.findAll();
		assertEquals(16, products.size());
		
	}
	
	@Test
	public void findAllByGenderTest() 
	{
		List<Products> products = productRepository.findAllByGender("Men");
		assertEquals(8, products.size());
	}
	
	@Test
	public void testFindByCategoryid() {
		List<Products> products = productRepository.findByCategoryid(2);
		products.forEach(product -> System.out.println(product));
	}
	
	//TODO: add CRUD tests

}
