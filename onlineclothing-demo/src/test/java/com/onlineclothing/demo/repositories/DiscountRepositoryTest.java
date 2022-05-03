package com.onlineclothing.demo.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineclothing.demo.entities.Discount;

@SpringBootTest
class DiscountRepositoryTest {
	
	@Autowired
	private DiscountRepository discountRepository;

	@Test
	public void findTop1ByCategoryIdAndStatusOrderByDiscountPercentDescTest() {
		
		Discount discount = discountRepository.findTop1ByCategoryidAndStatusOrderByDiscountPercentDesc(1, "live");
		System.out.println(discount);
	}

}
