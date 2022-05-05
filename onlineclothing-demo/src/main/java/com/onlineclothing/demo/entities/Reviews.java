package com.onlineclothing.demo.entities;

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
@Getter
@Setter
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

	@Override
	public String toString() {
		return "Reviews [reviewid=" + reviewid + ", userid=" + userid + ", orderlineid=" + orderlineid + ", productid="
				+ productid + ", rating=" + rating + ", review=" + review + "]";
	}
	
	
	
}
