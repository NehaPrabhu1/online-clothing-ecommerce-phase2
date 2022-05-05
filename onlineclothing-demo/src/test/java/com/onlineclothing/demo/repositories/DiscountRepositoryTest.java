package com.onlineclothing.demo.repositories;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineclothing.demo.entities.Discount;

@SpringBootTest
class DiscountRepositoryTest {
	
	@Autowired
	private DiscountRepository discountRepository;
	
	@Test
	public void testFindAll() {
		List<Discount> findAll = discountRepository.findAll();
		System.out.println(findAll);
	}

	@Test
	public void findTop1ByCategoryIdAndStatusOrderByDiscountPercentDescTest() {
		
		Discount discount = discountRepository.findTop1ByCategoryidAndStatusOrderByDiscountPercentDesc(1, "live");
		System.out.println(discount);
	}
	
	@Test
	public void testFindByCategoryid() {
		Integer categoryid = 2;
		List<Discount> discountsByCategory = discountRepository.findByCategoryid(categoryid);
		System.out.println(discountsByCategory);
	}

}
