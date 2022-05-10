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
		//when(brandservice.finprobybarnd()).thenReturn(listofProduts) use mockito
		List<Products> products = brandService.findProductsByBrand(id);
		products.forEach(product->System.out.println(product));
		assertEquals(1, products.get(0).getBrandid());
	}
	
	@Test
	void testFindAllBrands() {
		List<Brands> allBrands = brandService.findAllBrands();
		System.out.println(allBrands);
		assertNotNull(allBrands);
	}

	@Test 
	void testBrandCount() {
		long count = brandService.getBrandsCount();
		System.out.println(count);
	}
}
