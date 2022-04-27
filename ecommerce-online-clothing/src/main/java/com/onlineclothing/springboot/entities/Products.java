package com.onlineclothing.springboot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productid;
	
	@ManyToOne
	@JoinColumn(name="brandid",insertable = false, updatable = false)
	private Brands brand;
	
	@ManyToOne
	@JoinColumn(name="categoryid",insertable = false, updatable = false)
	private Categories category;

	private Integer categoryid;//dropdown
	
	private Integer brandid;
	
	@Column(name="product_name")
	private String productName; //text
	
	private double price;//text
	
	private String color;//text
	
	private double discount;
	
	@Column(name = "product_image")
	private String productImage;//text or file
}
