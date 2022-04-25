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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long productid;

    @Column(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryid", referencedColumnName = "categoryid")
    private Categories category;
    
    @Column(nullable = false)
    private String productname;

    private String description;
    
    @Column(nullable = false)
    private BigDecimal price;
    
    private String color;
    
    private String imageUrl;
    
}