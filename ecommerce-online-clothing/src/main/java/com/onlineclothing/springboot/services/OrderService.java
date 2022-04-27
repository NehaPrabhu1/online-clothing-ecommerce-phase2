package com.onlineclothing.springboot.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineclothing.springboot.entities.Orders;
import com.onlineclothing.springboot.repositories.OrderRepository;


@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public Orders insertNewOrder(Orders order) {
		Orders newOrder = new Orders();
//		Set<Orderline> orderlines = order.getOrderlines();
//		if(orderlines!=null) {
//		
//		}
		return newOrder;
	}
	
	

}
