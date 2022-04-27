package com.onlineclothing.springboot.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class CategoriesTest {
	
	@Test
	public void getCategoryIdTest() {
		Categories category = new Categories();
		category.setCategoryid(15);
		assertEquals(15, category.getCategoryid());
	}
	
	@Test
	public void getCategory_nameTest() {
		Categories category = new Categories();
		category.setCategory_name("A");
		assertEquals("A", category.getCategory_name());
	}
	
	@Test
	public void getCategory_genderTest() {
		Categories category = new Categories();
		category.setCategory_gender("Either");
		assertEquals("Either", category.getCategory_gender());
	}
	
	@Test
	public void getCategory_typeTest() {
		Categories category = new Categories();
		category.setCategory_type("Outerwear");
		assertEquals("Outerwear", category.getCategory_type());
	}

}
