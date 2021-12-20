package com.gymshop.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.gymshop.entities.PaymentMethod;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data 
@AllArgsConstructor 
@NoArgsConstructor
@Entity 
@Table(name = "Orders")
public class Order implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String address;
	@Temporal(TemporalType.DATE)
	@Column(name = "Createdate")
	Date createDate = new Date();
	
	@ManyToOne
	@JoinColumn(name = "Username")
	Account account;
	
	
	@ManyToOne
	@JoinColumn(name = "order_status_id")
	OrderStatus orderStatus;
	

	@ManyToOne
	@JoinColumn(name = "payment_method_id")
	PaymentMethod paymentMethod;

	@Column(name="notes")
	String notes;

	@Column(name="phone")
	String phone;

	@Column(name="name")
	String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "order")
	List<OrderDetail> orderDetails;
}
