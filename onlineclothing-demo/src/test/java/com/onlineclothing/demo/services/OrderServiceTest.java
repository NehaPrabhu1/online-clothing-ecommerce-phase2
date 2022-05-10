package com.onlineclothing.demo.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineclothing.demo.entities.Orders;

@SpringBootTest
class OrderServiceTest {
	
	@Autowired
	OrderService orderService;
	

	@Test
	void testInsertNewOrder() {
		OrderService orderServiceMock = mock(OrderService.class);
		Orders order = new Orders();
		when(orderServiceMock.insertNewOrder(order)).thenReturn(order);
		Orders newOrder = orderService.insertNewOrder(order);
		assertEquals(order, newOrder);	
	}
	
	@Test
	void testFindAllOrders() {
		List<Orders> allOrders = orderService.findAllOrders();
		System.out.println(allOrders);
		assertNotNull(allOrders);
	}

	@Test
	void testFindOrderById_OrderExists() {
		Orders order = orderService.findOrderById(2);
		System.out.println(order);
		assertEquals(2, order.getOrderid());
	}
	
	@Test
	void testFindOrderById_OrderNotExists() {
		Orders order = orderService.findOrderById(200);
		System.out.println(order);
		assertNull(order);
	}
	
	@Test
	void testFindOrdersOfUser() {
		List<Orders> orders = orderService.findOrdersOfUser(2);
		System.out.println(orders);
		Orders order = orders.get(0);
		assertEquals(2, order.getUserid());
	}
	
	@Test
	void testFindOrdersOfUserAndApplySorting() {
		List<Orders> orders = orderService.findOrdersOfUserAndApplySorting(2);
		LocalDateTime order1 = LocalDateTime.of(orders.get(0).getDateOfOrder(),
												orders.get(0).getTimeOfOrder());
		LocalDateTime order2 = LocalDateTime.of(orders.get(1).getDateOfOrder(),
								orders.get(1).getTimeOfOrder());
		assertTrue(order1.isAfter(order2));
		
	}
	
	@Test
	void testGetOrdersCount() {
		long ordersCount = orderService.getOrdersCount();
		System.out.println(ordersCount);
		assertTrue(ordersCount>=0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
