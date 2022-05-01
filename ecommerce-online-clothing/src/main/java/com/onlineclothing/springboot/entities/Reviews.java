package com.onlineclothing.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


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
//@ToString
public class Reviews {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reviewid;
	
	private Integer userid;
	
	private Integer orderlineid;
	
	private Integer productid;
	
	private int rating;
	
	private String review;
	
	@OneToOne
	@JoinColumn(name="orderlineid",referencedColumnName = "orderlineid",insertable = false, updatable = false)
	@JsonIgnore
	private Orderline orderline;
	
	@ManyToOne
	@JoinColumn(name="userid",insertable = false, updatable = false)
	private Users user;

	public Integer getReviewid() {
		return reviewid;
	}

	public void setReviewid(Integer reviewid) {
		this.reviewid = reviewid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getOrderlineid() {
		return orderlineid;
	}

	public void setOrderlineid(Integer orderlineid) {
		this.orderlineid = orderlineid;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Orderline getOrderline() {
		return orderline;
	}

	public void setOrderline(Orderline orderline) {
		this.orderline = orderline;
	}
	
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Reviews [reviewid=" + reviewid + ", userid=" + userid + ", orderlineid=" + orderlineid + ", productid="
				+ productid + ", rating=" + rating + ", review=" + review + "]";
	}

	
	
}
