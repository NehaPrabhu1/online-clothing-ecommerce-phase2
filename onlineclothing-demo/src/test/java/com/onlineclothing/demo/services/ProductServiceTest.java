package com.onlineclothing.demo.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineclothing.demo.entities.Brands;
import com.onlineclothing.demo.entities.Categories;
import com.onlineclothing.demo.entities.Products;
import com.onlineclothing.demo.repositories.ProductRepository;


@SpringBootTest
class ProductServiceTest {

	@Autowired ProductRepository productRepository;
	@Autowired ProductService productService;
	
	@Test
	public void injectedComponentsNotNullTest() {
	    assertThat(productRepository).isNotNull();
	    assertThat(productService).isNotNull();
	}
	
	@Test
	public void getProductsBasedOnPageTest() {
		List<Products> products = productService.getProductsBasedOnPage(0, 4);
		assertEquals(4, products.size());
	}
	
	
	@Test
	public void getAllProductsTest() {
		List<Products> products = productService.getAllProducts();
		System.out.println(products);
		assertNotNull(products);
	}
	
	@Test
	public void searchProductsTest() {
		List<Products> products = productService.searchProducts("men");
		System.out.println(products);
	}
	
	@Test
	public void getProductByIdTest() {
		Products product = new Products();
		Brands brand = new Brands();
		Categories category = new Categories();
		
		brand.setBrandid(1);
		brand.setBrandName("ABC");
		
		category.setCategoryid(2);
		category.setCategoryGender("Men");
		category.setCategoryType("Topwear");
		category.setCategoryName("Tshirt");
		
		product.setProductid(1);
		product.setBrand(brand);
		product.setCategory(category);
		product.setProductName("Men blue polo shirt");
		product.setPrice(500);
		product.setColor("blue");
		product.setProductImage("assets/images/products/img1.jpg");
		
		Products retrievedProduct = productService.getProductById(1);
		assertEquals(product.getProductName(), retrievedProduct.getProductName());
		assertEquals(product.getPrice(), retrievedProduct.getPrice());
		
		retrievedProduct = productService.getProductById(10000000);
		assertThat(retrievedProduct).isNull();
	}
	
	@Test
	public void getProductsByGenderTest() {
		List<Products> products = productService.getProductsByGender("Men");
		Products product = products.get(0);
		assertEquals("Men", product.getCategory().getCategoryGender());
	}
	
	@Test
	void testGetProductsCount() {
		long productCount = productService.getProductsCount();
		System.out.println(productCount);
		assertTrue(productCount>=0);
	}

	
	@Test
	void testGetProductsByColor() {
		List<Products> products = productService.getProductsByColor("blue");
		assertNotNull(products);
		assertEquals("blue", products.get(0).getColor());
	}
}
