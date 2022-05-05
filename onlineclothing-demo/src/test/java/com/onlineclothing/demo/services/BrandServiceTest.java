package com.onlineclothing.demo.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineclothing.demo.entities.Brands;
import com.onlineclothing.demo.entities.Products;

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
	
	@Test
	void testFindAllBrands() {
		List<Brands> brands = brandService.findAllBrands();
		System.out.println(brands);
	}

	@Test 
	void testBrandCount() {
		long count = brandService.getBrandsCount();
		System.out.println(count);
	}
}
