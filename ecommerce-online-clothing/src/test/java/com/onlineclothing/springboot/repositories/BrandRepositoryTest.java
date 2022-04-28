package com.onlineclothing.springboot.repositories;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineclothing.springboot.entities.Brands;


@SpringBootTest
class BrandRepositoryTest {
	
	@Autowired
	private BrandRepository brandRepository;

	@Test
	void testFindAllBrands() {
		List<Brands> allBrands = brandRepository.findAll();
		allBrands.forEach(brand -> System.out.println(brand));	
	}
	
	@Test
	void testFindById() {
		int id = 2;
		Optional<Brands> optional = brandRepository.findById(id);
		System.out.println(optional.get());
	}

}
