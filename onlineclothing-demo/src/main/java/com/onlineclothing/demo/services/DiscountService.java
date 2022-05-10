package com.onlineclothing.demo.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineclothing.demo.entities.Discount;
import com.onlineclothing.demo.repositories.DiscountRepository;

@Service
public class DiscountService {

	@Autowired
	private DiscountRepository discountRepository;

	public void updateStatus(Discount discount) {
		LocalDate startDate = discount.getStartDate();
		LocalTime startTime = discount.getStartTime();

		LocalDate endDate = discount.getEndDate();
		LocalTime endTime = discount.getEndTime();

		/**
		 * 			start ------------------------------------------ end 
		 * now 							now 								now
		 */
		LocalDateTime startTimeStamp = LocalDateTime.of(startDate, startTime);
		LocalDateTime endTimeStamp = LocalDateTime.of(endDate, endTime);
		LocalDateTime currentTimeStamp = LocalDateTime.now();

		if (currentTimeStamp.isBefore(startTimeStamp)) {
			discount.setStatus("upcoming");
		} else if (currentTimeStamp.isAfter(endTimeStamp)) {
			discount.setStatus("expired");
		} else if(currentTimeStamp.isAfter(startTimeStamp) && currentTimeStamp.isBefore(endTimeStamp)){
			discount.setStatus("live");
		}
	}

	public List<Discount> updateDiscount(){
		List<Discount> discounts = discountRepository.findAll();
		for (Discount discount : discounts) {
			updateStatus(discount);
		}
		List<Discount> updatedDiscounts = discountRepository.saveAll(discounts);
		return updatedDiscounts;
	}

	public Discount newDiscount(Discount discount){
		Discount savedDiscount = null;
		if(discount != null) {
			updateStatus(discount);
			savedDiscount = discountRepository.save(discount);
		}
		return savedDiscount;
	}

	public List<Discount> getDiscountByCategory(Integer categoryid) {
		updateDiscount();
		return discountRepository.findByCategoryid(categoryid);
	}
	
	public Discount getLiveDiscountByCategory(Integer categoryid) {
		updateDiscount();
		return discountRepository.findTop1ByCategoryidAndStatusOrderByDiscountPercentDesc(categoryid,"live");
	}
	
	public long getDiscountCount() {
		return discountRepository.count();
	}

}
