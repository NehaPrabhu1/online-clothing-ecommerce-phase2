package com.onlineclothing.springboot.services;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineclothing.springboot.entities.Discount;


@SpringBootTest
class DiscountServiceTest {
	
	@Autowired
	private DiscountService discountService;

	@Test
	public void updateStatusTest() {
		
		List<Discount> updatedDiscounts = discountService.updateDiscount();
		updatedDiscounts.forEach(
				discount->System.out.println(discount));
		
	}

}
