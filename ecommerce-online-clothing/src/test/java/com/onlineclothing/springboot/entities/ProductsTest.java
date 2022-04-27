package com.onlineclothing.springboot.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsTest {

	@Test
	public void getProductIdTest() {
		Products product = new Products();
		product.setProductid(50);
		assertEquals(50, product.getProductid());
	}
	
	@Test
	public void getCategoryTest() {
		Products product = new Products();
		Categories category = new Categories();
		category.setCategoryid(5);
		product.setCategory(category);
		assertEquals(5, product.getCategory().getCategoryid());
	}
	
	@Test
	public void getBrandTest() {
		Products product = new Products();
		Brands brand = new Brands();
		brand.setBrandid(10);
		product.setBrand(brand);
		assertEquals(10, product.getBrand().getBrandid());
	}
	
	@Test
	public void getProductNameTest() {
		Products product = new Products();
		product.setProductName("Men red shoes");
		assertEquals("Men red shoes", product.getProductName());
	}
	
	@Test
	public void getProductImageTest() {
		Products product = new Products();
		product.setProductImage("image1.png");
		assertEquals("image1.png", product.getProductImage());
	}
	
	@Test
	public void getPriceTest() {
		Products product = new Products();
		product.setPrice(1400);
		assertEquals(1400, product.getPrice());
	}
	
	@Test
	public void getColorTest() {
		Products product = new Products();
		product.setColor("green");
		assertEquals("green", product.getColor());
	}
	
	@Test
	public void getDiscountTest() {
		Products product = new Products();
		product.setDiscount(20);
		assertEquals(20, product.getDiscount());
	}
}
