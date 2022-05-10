package com.onlineclothing.demo.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.onlineclothing.demo.entities.Orderline;
import com.onlineclothing.demo.entities.Orders;
import com.onlineclothing.demo.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	// insert order
	public Orders insertNewOrder(Orders order) {
		Orders savedOrder = null;
		if (order != null)
			savedOrder = orderRepository.save(order);
		return savedOrder;
	}

	// get all orders
	public List<Orders> findAllOrders() {
		return orderRepository.findAll();
	}

	// get order by orderid
	public Orders findOrderById(Integer orderid) {
		Orders order = null;
		Optional<Orders> optional = orderRepository.findById(orderid);
		if (optional.isPresent()) {
			order = optional.get();
		}
		return order;
	}

	public List<Orders> findOrdersOfUser(Integer userid) {
		List<Orders> orders = orderRepository.findByUserid(userid);
		return orders;
	}

	// get orders of particular user and sort in desc order of their placement
	public List<Orders> findOrdersOfUserAndApplySorting(Integer userid) {

		Sort newSort = Sort.by(new Sort.Order(Direction.DESC, "dateOfOrder"), 
						new Sort.Order(Direction.DESC, "timeOfOrder"));
		 List<Orders> orders = orderRepository.findByUserid(userid, newSort);
		
		return orders;
	}
	
	 
    public long getOrdersCount() {
    	return orderRepository.count();
    }
	

}
