package com.onlineclothing.springboot.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.onlineclothing.springboot.entities.Orders;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderRepositoryTest {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Test
	public void testGetAllOrders() {
		List<Orders> orders = orderRepository.findAll();
		orders.forEach(order -> System.out.println(order));
	}

	

}
