package com.onlineclothing.springboot.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.onlineclothing.springboot.entities.DeliveryAddress;
import com.onlineclothing.springboot.entities.Orderline;
import com.onlineclothing.springboot.entities.Orders;
import com.onlineclothing.springboot.repositories.OrderRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceTest {

	@Autowired OrderRepository orderRepository;
	@Autowired OrderService orderService;

	@Test
	public void injectedComponentsNotNullTest() {
	    assertThat(orderRepository).isNotNull();
	    assertThat(orderService).isNotNull();
	}
	
	@Test
	public void insertNewOrderTest() {
		Orders order = new Orders();
		//Orderline orderlines = new Orderline();
		//orderlines.setOrderlineid(15);
		//orderlines.setProductid(5);
		//orderlines.setQuantity(1);
		//orderlines.setPrice(1000);
		order.setOrderid(3);
		order.setDateOfOrder(LocalDate.now());
		order.setTimeOfOrder(LocalTime.now());
		order.setTotalPayment(1000);
		order.setUserid(1);
		//order.setDeliveryAddress(new DeliveryAddress());
		
		Orders savedOrder = orderService.insertNewOrder(order);
		savedOrder = orderService.insertNewOrder(null);
		
	}
	
	@Test
	public void findAllOrdersTest() {
		List<Orders> orders = orderService.findAllOrders();
		//orders.forEach(order->System.out.println(order));
	}
	
	@Test
	public void findOrderByIdTest() {
		Orders order = orderService.findOrderById(1);
		System.out.println(order);
	}
	
	@Test
	public void findOrdersOfUser() {
		List<Orders> orders = orderService.findOrdersOfUser(2);
		orders.forEach(order->System.out.println(order));
	}
	
	@Test
	public void findOrdersOfUserAndApplySortingAndPagingTest() {
		List<Orders> orders = orderService.findOrdersOfUserAndApplySortingAndPaging(2, 0, 3);
		orders.forEach(order->System.out.println(order));
		
		// Should return null as invalid order id
		orders = orderService.findOrdersOfUserAndApplySortingAndPaging(15, 0, 0);
		
	}
	
	@Test
	public void getOrdersCount() {
		long count = orderService.getOrdersCount();
		System.out.println(count);
	}

}
