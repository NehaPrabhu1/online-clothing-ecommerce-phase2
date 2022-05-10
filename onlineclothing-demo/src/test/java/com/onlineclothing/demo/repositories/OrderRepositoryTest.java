package com.onlineclothing.demo.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.onlineclothing.demo.entities.DeliveryAddress;
import com.onlineclothing.demo.entities.Orderline;
import com.onlineclothing.demo.entities.Orders;

@SpringBootTest
class OrderRepositoryTest {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Test
	public void testGetAllOrders() {
		orderRepository.findAll().forEach(order -> System.out.println(order));
	}
	
	@Test
	public void testFindByUserid() {
		Integer userid = 2;
		List<Orders> orders = orderRepository.findByUserid(userid);
		System.out.println(orders);
	}
	
	
	@Test
	public void testFindByUserid_Sort() {
		Integer userid = 2;
		Sort newSort = Sort.by(new Sort.Order(Direction.DESC, "dateOfOrder"));
		List<Orders> orders = orderRepository.findByUserid(userid, newSort);
		System.out.println(orders);
	}
	
	@Test
	public void testSaveOrder() {
		Orders order = new Orders();
        order.setUserid(2);
        order.setTotalPayment(2000);

        // create order item 1
        Orderline orderline1 = new Orderline();
        orderline1.setProductid(2);
        orderline1.setPrice(1000);
        orderline1.setQuantity(1);
        orderline1.setSize("m");

        // create order item 2
        Orderline orderline2 = new Orderline();
        orderline2.setProductid(3);
        orderline2.setPrice(1000);
        orderline2.setQuantity(1);
        orderline2.setSize("l");

        Set<Orderline> orderlines = new HashSet<Orderline>();
        orderlines.add(orderline1);
        orderlines.add(orderline2);
        order.setOrderlines(orderlines);


        DeliveryAddress address = new DeliveryAddress();
        address.setAddressline("ABC Apartments, 44 Room, A wing");
        address.setCity("Pune");
        address.setStreet("Kothrud");
        address.setCountry("India");
        address.setPincode("411047");

        order.setDeliveryAddress(address);

        Orders savedOrder = orderRepository.save(order);
        System.out.println(savedOrder);
        
	}

	

}
