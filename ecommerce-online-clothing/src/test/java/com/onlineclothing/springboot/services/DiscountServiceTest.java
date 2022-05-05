package com.onlineclothing.springboot.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
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
	
	@Test
	public void newDiscountTest() {
		Discount discount = new Discount();
		discount.setDiscountid(40);
		discount.setCategoryid(2);
		discount.setStartDate(LocalDate.parse("2022-06-05"));
		discount.setStartTime(LocalTime.parse("15:35:00"));
		discount.setEndDate(LocalDate.parse("2022-07-05"));
		discount.setEndTime(LocalTime.parse("01:00:00"));
		discount.setDiscountPercent(15);
		Discount savedDiscount = discountService.newDiscount(discount);
		discountService.deleteByDiscountid(savedDiscount.getDiscountid());
		savedDiscount = discountService.newDiscount(null);
		
		discount = new Discount();
		discount.setDiscountid(40);
		discount.setCategoryid(2);
		discount.setStartDate(LocalDate.now());
		discount.setStartTime(LocalTime.now().minusHours(1));
		discount.setEndDate(LocalDate.now().plusWeeks(2));
		discount.setEndTime(LocalTime.now().plusHours(1));
		discount.setDiscountPercent(15);
		savedDiscount = discountService.newDiscount(discount);
		discountService.deleteByDiscountid(savedDiscount.getDiscountid());
		
	}
	
	@Test
	public void getDiscountByCategoryTest() {
		List<Discount> discounts = discountService.getDiscountByCategory(1);
		discounts.forEach(discount -> System.out.println(discount));
	}
	
	@Test
	public void getLiveDiscountByCategoryTest() {
		Discount discount = discountService.getLiveDiscountByCategory(1);
		System.out.println(discount);
	}
	
	@Test
	public void getDiscountCountTest() {
		long count = discountService.getDiscountCount();
		//assertEquals(3, count);
	}

}
