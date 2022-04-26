package com.onlineclothing.springboot.entities;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.Modifying;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "products", schema="public")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productid;
    
    @JsonManagedReference// Makes sure there's no infinite loop where the category gets a list of products,
    // which then contains a list of categories etc.
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Categories categoryid;
    
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "brandid")
    private Brands brandid;
    
    @Column(name = "product_name", nullable = false)
    private String productname;
    
    @Column(nullable = false)
    private BigDecimal price;
    
    private String color;
    
    private String product_image;

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Categories getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Categories categoryid) {
		this.categoryid = categoryid;
	}

	public Brands getBrandid() {
		return brandid;
	}

	public void setBrandid(Brands brandid) {
		this.brandid = brandid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProduct_name(String productname) {
		this.productname = productname;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
    
    
    
}