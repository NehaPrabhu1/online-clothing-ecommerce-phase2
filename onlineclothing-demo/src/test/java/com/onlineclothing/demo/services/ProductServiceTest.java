package com.onlineclothing.demo.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.onlineclothing.demo.entities.Brands;
import com.onlineclothing.demo.entities.Categories;
import com.onlineclothing.demo.entities.Products;
import com.onlineclothing.demo.repositories.ProductRepository;



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
		assertEquals(1, products.get(0).getProductid());
		
		// Checking the conditional 
	    products = productService.getProductsBasedOnPage(50, 10);
	}
	
	@Test
	public void getAllProductsTest() {
		List<Products> products = productService.getAllProducts();
		System.out.println(products);
		assertThat(products.size()).isEqualTo(16);
	}
	
	@Test
	public void searchProductsTest() {
		List<Products> products = productService.searchProducts("men");
		assertThat(products.size()).isEqualTo(16);
		assertEquals(1, products.get(0).getProductid());
		assertEquals(2, products.get(1).getProductid());
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
		product.setDiscount(20);
		product.setProductImage("assets/images/products/img1.jpg");
		
		Products retrievedProduct = productService.getProductById(1);
		assertEquals(product.getProductName(), retrievedProduct.getProductName());
		assertEquals(product.getPrice(), retrievedProduct.getPrice());
		assertEquals(product.getDiscount(), retrievedProduct.getDiscount());
		
		
		retrievedProduct = productService.getProductById(10000000);
		assertThat(retrievedProduct).isNull();
	}
	
	@Test
	public void getProductsByGenderTest() {
		List<Products> products = productService.getProductsByGender("Men");
		assertEquals(8, products.size());
		assertEquals(1, products.get(0).getProductid());
		assertEquals(3, products.get(1).getProductid());
	}

}
