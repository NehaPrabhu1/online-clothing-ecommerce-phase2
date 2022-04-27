package com.onlineclothing.springboot.repositories;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderRepositoryTest {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Test
	public void testGetAllOrders() {
		orderRepository.findAll().forEach(order -> System.out.println(order));
	}

	

}
