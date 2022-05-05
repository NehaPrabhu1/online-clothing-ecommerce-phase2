package com.onlineclothing.springboot.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.onlineclothing.springboot.entities.Reviews;

@RunWith(SpringRunner.class)
@SpringBootTest
class ReviewServiceTest {
	
	@Autowired
	ReviewService reviewService;

	@Test
	public void insertNewReviewTest() {
		Reviews review = new Reviews();
		reviewService.insertNewReview(review);
	}

	@Test
	public void findAllReviewsTest() {
		List<Reviews> reviews = reviewService.findAllReviews();
		reviews.forEach(review -> System.out.println(review));
	}
}
