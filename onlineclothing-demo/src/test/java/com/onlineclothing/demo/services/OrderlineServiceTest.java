package com.onlineclothing.demo.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderlineServiceTest {
	
	@Autowired
	OrderlineService orderlineService;

	@Test
	void testGetOrderlineCount() {
		long orderlineCount = orderlineService.getOrderlineCount();
		System.out.println(orderlineCount);
		assertTrue(orderlineCount>0);
		
	}

}
