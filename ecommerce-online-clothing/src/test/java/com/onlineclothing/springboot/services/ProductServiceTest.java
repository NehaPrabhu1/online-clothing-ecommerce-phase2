package com.onlineclothing.springboot.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import javax.activation.DataSource;
import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.onlineclothing.springboot.entities.Brands;
import com.onlineclothing.springboot.entities.Categories;
import com.onlineclothing.springboot.entities.Products;
import com.onlineclothing.springboot.repositories.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

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
		products.forEach(product -> System.out.println(product));
		
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
		products.forEach(product -> System.out.println(product));
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
		
		
		retrievedProduct = productService.getProductById(10000000);
		assertThat(retrievedProduct).isNull();
	}
	
	@Test
	public void getProductsByGenderTest() {
		List<Products> products = productService.getProductsByGender("Men");
		assertEquals(8, products.size());
		products.forEach(product -> System.out.println(product));
	}
	
	@Test
	public void updateProductDiscountTest() {
		
	}
	
	@Test
	public void getProductsByColorTest() {
		List<Products> products = productService.getProductsByColor("blue");
		products.forEach(product -> System.out.println(product));
	}
	
	@Test
	public void saveTest() {
		Products product = new Products();
		Brands brand = new Brands();
		Categories category = new Categories();
		product.setBrandid(1);
		product.setCategoryid(2);
		/*
		brand.setBrandid(1);
		brand.setBrandName("ABC");
		
		category.setCategoryid(2);
		category.setCategoryGender("Men");
		category.setCategoryType("Topwear");
		category.setCategoryName("Tshirt");
		*/
		product.setProductid(17);
		product.setBrand(brand);
		product.setCategory(category);
		product.setProductName("Men green polo shirt");
		product.setPrice(1500);
		product.setColor("green");
		product.setDiscount(5);
		product.setProductImage("assets/images/products/img17.jpg");
		
		System.out.println("HELLO" + product.toString());
		Products savedProduct = productService.save(product);
		//assertEquals("green", productService.getProductById(savedProduct.getProductid()).getColor());
		productService.deleteById(savedProduct.getProductid());
	}
	
	@Test
	public void getProductsCount() {
		long count = productService.getProductsCount();
		assertEquals(16, count);
	}
	
	
}
