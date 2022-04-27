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
	public void getCategoryNameTest() {
		Categories category = new Categories();
		category.setCategoryName("A");
		assertEquals("A", category.getCategoryName());
	}
	
	@Test
	public void getCategoryGenderTest() {
		Categories category = new Categories();
		category.setCategoryGender("Either");
		assertEquals("Either", category.getCategoryGender());
	}
	
	@Test
	public void getCategoryTypeTest() {
		Categories category = new Categories();
		category.setCategoryType("Outerwear");
		assertEquals("Outerwear", category.getCategoryType());
	}

}
