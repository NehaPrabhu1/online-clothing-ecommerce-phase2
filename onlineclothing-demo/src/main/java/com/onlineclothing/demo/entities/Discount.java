package com.onlineclothing.demo.entities;

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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Discount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "discountid")
	private Integer discountid;

	@Column(name="categoryid")
	private Integer categoryid;

	@Column(name="start_date")
	private LocalDate startDate;

	@Column(name="start_time")
	private LocalTime startTime;

	@Column(name="end_date")
	private LocalDate endDate;

	@Column(name="end_time")
	private LocalTime endTime;
	
	@Column(name="discount_percent")
	private double discountPercent;
	
	private String status;

}
