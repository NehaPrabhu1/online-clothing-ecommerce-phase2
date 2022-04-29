package com.onlineclothing.springboot.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
//@ToString
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderid;

	private Integer userid;

	@CreationTimestamp
	@Column(name = "date_of_order")
	private LocalDate dateOfOrder;

	@CreationTimestamp
	@Column(name = "time_of_order")
	private LocalTime timeOfOrder;

	@Column(name = "total_payment")
	private double totalPayment;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "orderid", referencedColumnName = "orderid")
	private Set<Orderline> orderlines = new HashSet<Orderline>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressid")
	private DeliveryAddress deliveryAddress;

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public LocalDate getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(LocalDate dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public LocalTime getTimeOfOrder() {
		return timeOfOrder;
	}

	public void setTimeOfOrder(LocalTime timeOfOrder) {
		this.timeOfOrder = timeOfOrder;
	}

	public double getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(double totalPayment) {
		this.totalPayment = totalPayment;
	}

	public Set<Orderline> getOrderlines() {
		return orderlines;
	}

	public void setOrderlines(Set<Orderline> orderlines) {
		this.orderlines = orderlines;
	}

	public DeliveryAddress getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	@Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", userid=" + userid + ", dateOfOrder=" + dateOfOrder + ", timeOfOrder="
				+ timeOfOrder + ", totalPayment=" + totalPayment + "]";
	}

}
