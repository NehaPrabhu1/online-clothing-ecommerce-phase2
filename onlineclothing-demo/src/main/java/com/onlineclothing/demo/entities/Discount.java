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
	private Integer categoryid; //dropdown <option [value] = category.id>{{category.name}}</option>

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

}
