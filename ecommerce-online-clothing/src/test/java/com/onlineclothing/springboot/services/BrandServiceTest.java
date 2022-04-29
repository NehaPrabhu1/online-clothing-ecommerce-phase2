package com.onlineclothing.springboot.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineclothing.springboot.entities.Products;

@SpringBootTest
class BrandServiceTest {
	
	@Autowired
	private BrandService brandService;

	@Test
	void testGetProductsByBrand() {
		int id = 1;
		List<Products> products = brandService.findProductsByBrand(id);
		products.forEach(product->System.out.println(product));
	}

}
