package com.onlineclothing.springboot.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Discount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "discountid")
	private Integer discountid;

	@Column(name="categoryid")
	private Integer categoryid; //changed from categoryId to categoryid to match with the database

	@Column(name="start_date")
	private LocalDate startDate;//date

	@Column(name="start_time")
	private LocalTime startTime;//time

	@Column(name="end_date")
	private LocalDate endDate;//date

	@Column(name="end_time")
	private LocalTime endTime;//time
	
	@Column(name="discount_percent")
	private double discountPercent;//number/normal
	
	private String status;
	

	public Integer getDiscountid() {
		return discountid;
	}

	public void setDiscountid(Integer discountid) {
		this.discountid = discountid;
	}

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
