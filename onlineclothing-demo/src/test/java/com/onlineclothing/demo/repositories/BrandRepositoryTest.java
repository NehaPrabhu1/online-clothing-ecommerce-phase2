package com.onlineclothing.demo.repositories;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineclothing.demo.entities.Brands;

@SpringBootTest
class BrandRepositoryTest {
	
	@Autowired
	private BrandRepository brandRepository;

	@Test
	void testFindAllBrands() {
		List<Brands> allBrands = brandRepository.findAll();
		allBrands.forEach(brand -> System.out.println(brand));	
	}

}
