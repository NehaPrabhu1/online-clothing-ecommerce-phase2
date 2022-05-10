package com.onlineclothing.demo.services;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineclothing.demo.entities.Discount;

@SpringBootTest
class DiscountServiceTest {

	@Autowired
	private DiscountService discountService;

	@Test
	public void testUpdateStatusTest() {
		List<Discount> updatedDiscounts = discountService.updateDiscount();
		updatedDiscounts.forEach(discount -> System.out.println(discount));
	}

	@Test
	void testGetDiscountCount() {
		Long discountCount = discountService.getDiscountCount();
		System.out.println(discountCount);
		assertTrue(discountCount>0);
	}
	
	@Test
	void testNewDiscount() {
		Discount discount = new Discount(20, 1, LocalDate.of(2022, 03, 22),LocalTime.of(10, 00),
				LocalDate.of(2022, 03, 23),LocalTime.of(10, 00),5,"live");
		Discount newDiscount = discountService.newDiscount(discount);
		assertEquals("expired", newDiscount.getStatus());
	}
	
	@Test
	void testGetDiscountByCategory() {
		List<Discount> discounts = discountService.getDiscountByCategory(2);
		System.out.println(discounts);
		assertTrue(discounts.size() >= 0);
	}
	
	@Test
	void testGetLiveDiscountByCategory() {
		Discount discountByCategory = discountService.getLiveDiscountByCategory(1);
		System.out.println(discountByCategory);	
	}
	
	

}
