package com.onlineclothing.springboot.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.onlineclothing.springboot.entities.Orders;
import com.onlineclothing.springboot.repositories.OrderRepository;


@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	//insert order
	public Orders insertNewOrder(Orders order) {
		Orders savedOrder = null;
		if(order != null)
			savedOrder = orderRepository.save(order);
		return savedOrder;
	}
	
	//get all orders
	public List<Orders> findAllOrders(){
		return orderRepository.findAll();
	}
	
	//get order by id
	public Orders findOrderById(Integer orderid) {
		Orders order = null;
		Optional<Orders> optional = orderRepository.findById(orderid);
		if(optional.isPresent()) {
			order = optional.get();
		}
		return order;
	}
	
	//get orders of particular user and sort in desc order of their placement
	public List<Orders> findOrdersOfUser(Integer userid, int pageNo, int size){
		Pageable pageable = PageRequest.of(pageNo, size, 
				Sort.by(new Sort.Order(Direction.DESC, "dateOfOrder"), 
						new Sort.Order(Direction.DESC, "timeOfOrder")));
		List<Orders> orders = orderRepository.findByUserid(userid, pageable);
		return orders;
	}
	
	

}
