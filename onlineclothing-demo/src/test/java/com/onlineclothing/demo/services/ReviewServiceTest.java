package com.onlineclothing.demo.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineclothing.demo.entities.Reviews;

@SpringBootTest
class ReviewServiceTest {
	
	@Autowired
	ReviewService reviewService;

	@Test
	void testfindAllReviews() {
		List<Reviews> allReviews = reviewService.findAllReviews();
		System.out.println(allReviews);
		assertNotNull(allReviews);
	}
	
	@Test
	void testInsertNewReview() {
		Reviews review = new Reviews();
		review.setOrderlineid(18);
		review.setProductid(1);
		review.setUserid(2);
		review.setRating(3);
		review.setReview("Ok product. Quality is not upto the mark.");
		
		Reviews newReview = reviewService.insertNewReview(review);
		assertEquals(review, newReview);
		
	}

}
