package com.onlineclothing.springboot.repositories;

<<<<<<< Updated upstream
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
=======
<<<<<<< Updated upstream
=======
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
>>>>>>> Stashed changes
>>>>>>> Stashed changes
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlineclothing.springboot.entities.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{
<<<<<<< Updated upstream
=======
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
	
	Page<Orders> findByUserid(Integer userid, Pageable pageable);
	
	List<Orders> findByUserid(Integer userid);
<<<<<<< Updated upstream
=======

	Optional<Orders> findByOrderid(Integer orderid);
>>>>>>> Stashed changes
>>>>>>> Stashed changes
}
