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


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor 
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(name = "name")
	String name;
	@Column(name = "image")
	String image;
	@Column(name = "special")
	Boolean special;
	@Column(name = "price")
	Double price;
	@Column(name = "description")
	String description;
	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	Category categoryId;
	@Column(name = "create_date")
	Date createdate = new Date();
	@ManyToOne
	@JoinColumn(name = "product_status_id")
	ProductStatus productStatus;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<OrderDetail> orderDetails;

}
