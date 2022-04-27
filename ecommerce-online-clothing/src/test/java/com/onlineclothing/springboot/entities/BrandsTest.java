package com.onlineclothing.springboot.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BrandsTest {

	@Test
	public void getBrandidTest() {
		Brands brand = new Brands();
		brand.setBrandid(5);
		assertEquals(5, brand.getBrandid());
	}
	
	@Test
	public void getBrandNameTest() {
		Brands brand = new Brands();
		brand.setBrandName("RTY");
		assertEquals("RTY", brand.getBrandName());
	}
}
