package com.onlineclothing.demo.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

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
//@ToString
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

	private Integer categoryid;
	
	private Integer brandid;
	
	@Column(name="product_name")
	private String productName; 
	
	private double price;
	
	private String color;
	
	private double discount;
	
	@Column(name = "product_image")
	private String productImage;
	
	@OneToMany
	@JoinColumn(name="productid",insertable = false, updatable = false)
	private List<Reviews> productReviews;
	
	//toString() does not affect the json object created - used only to display object in sysout (needed for testing)
	@Override
	public String toString() {
		return "Products [productid=" + productid + ", categoryid=" + categoryid + ", brandid=" + brandid
				+ ", productName=" + productName + ", price=" + price + ", color=" + color + ", discount=" + discount
				+ ", productImage=" + productImage + "]";
	}
}


