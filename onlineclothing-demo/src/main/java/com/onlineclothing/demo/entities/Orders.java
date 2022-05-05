package com.onlineclothing.demo.entities;

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
@Getter
@Setter
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
	
	@OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="orderid",referencedColumnName = "orderid")
	private Set<Orderline> orderlines = new HashSet<Orderline>();
	
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="addressid")//changed from @PrimaryKeyJoinColumn to @JoinColumn
    private DeliveryAddress deliveryAddress;
       
    @Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", userid=" + userid + ", dateOfOrder=" + dateOfOrder + ", timeOfOrder="
				+ timeOfOrder + ", totalPayment=" + totalPayment + "]";
	}

}
