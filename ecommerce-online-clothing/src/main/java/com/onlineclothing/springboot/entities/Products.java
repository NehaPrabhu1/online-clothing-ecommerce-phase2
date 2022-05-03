package com.onlineclothing.springboot.entities;

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

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
//@ToString - created new toString() below - does not affect the code
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productid;

	@ManyToOne
	@JoinColumn(name = "brandid", insertable = false, updatable = false)
	private Brands brand;

	@ManyToOne
	@JoinColumn(name = "categoryid", insertable = false, updatable = false)
	private Categories category;
	
	private Integer categoryid;//do not delete imp for inserting new products, created getter and setter
	
	private Integer brandid;//do not delete imp for inserting new products, created getter and setter

	@Column(name = "product_name", nullable = false)
	private String productName;

	@Column(nullable = false)
	private double price;

	private String color;

	private double discount;

	@OneToMany
	@JoinColumn(name="productid",insertable = false, updatable = false)
	private List<Reviews> productReviews;
	
	
	@Column(name = "product_image")
	private String productImage;

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public Brands getBrand() {
		return brand;
	}

	public void setBrand(Brands brand) {
		this.brand = brand;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public Integer getBrandid() {
		return brandid;
	}

	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
	}
	
	public List<Reviews> getProductReviews() {
		return productReviews;
	}

	public void setProductReviews(List<Reviews> productReviews) {
		this.productReviews = productReviews;
	}

	//toString() does not affect the json object created - used only to display object in sysout (needed for testing)
	@Override
	public String toString() {
		return "Products [productid=" + productid + ", categoryid=" + categoryid + ", brandid=" + brandid
				+ ", productName=" + productName + ", price=" + price + ", color=" + color + ", discount=" + discount
				+ ", productImage=" + productImage + "]";
	}

	
	
	
}
