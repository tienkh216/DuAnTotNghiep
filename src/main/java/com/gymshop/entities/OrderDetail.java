package com.gymshop.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@SuppressWarnings("serial")
@Entity
@Table(name="Order_Details")
public class OrderDetail implements Serializable{
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	Order order;	
	@Column(name="price")
	Double price;
	
	@Column(name="quantity")
	Integer quantity;
	@ManyToOne
	@JoinColumn(name = "Productid")
	Product product;
}
