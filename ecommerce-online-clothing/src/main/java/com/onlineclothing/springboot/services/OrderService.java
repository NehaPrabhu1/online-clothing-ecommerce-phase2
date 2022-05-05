package com.onlineclothing.springboot.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

	// insert order
	public Orders insertNewOrder(Orders order) {
<<<<<<< Updated upstream
=======
<<<<<<< Updated upstream
		Orders newOrder = new Orders();
//		Set<Orderline> orderlines = order.getOrderlines();
//		if(orderlines!=null) {
//		
//		}
		return newOrder;
=======
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
		Optional<Orders> optional = orderRepository.findById(orderid);
=======
		Optional<Orders> optional = orderRepository.findByOrderid(orderid);
>>>>>>> Stashed changes
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
	public List<Orders> findOrdersOfUserAndApplySortingAndPaging(Integer userid, int pageNo, int size) {
		List<Orders> orders = null;
		if (size <= 0)
			size = 2;
		if (pageNo <= 0)
			pageNo = 0;

		orders = findOrdersOfUser(userid);
		if (orders.isEmpty()) {
			return orders;
		}

		Pageable pageable = PageRequest.of(pageNo, size);
		Page<Orders> page = orderRepository.findByUserid(userid, pageable);
		int totalPages = page.getTotalPages();
		if (totalPages <= pageNo) {
			pageNo = totalPages - 1;
		}

		pageable = PageRequest.of(pageNo, size,
				Sort.by(new Sort.Order(Direction.DESC, "dateOfOrder"), 
						new Sort.Order(Direction.DESC, "timeOfOrder")));
		page = orderRepository.findByUserid(userid, pageable);
		if (page.hasContent()) {
			orders = page.getContent();
		}
		return orders;
<<<<<<< Updated upstream
=======
>>>>>>> Stashed changes
>>>>>>> Stashed changes
	}
	
	 
    public long getOrdersCount() {
    	return orderRepository.count();
    }


}
