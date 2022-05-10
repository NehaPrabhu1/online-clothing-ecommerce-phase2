package com.onlineclothing.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
public class Orderline {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderlineid")
	private Integer orderlineid;

	private Integer productid;
	
	@ManyToOne
    @JoinColumn(name = "productid",insertable = false, updatable = false)
    private Products product;


	private String size;

	private int quantity;

	private double price;


	@OneToOne(cascade=CascadeType.ALL, mappedBy ="orderline")
	@JoinColumn(name="orderlined",insertable = false, updatable = false)
	private Reviews review;

}










