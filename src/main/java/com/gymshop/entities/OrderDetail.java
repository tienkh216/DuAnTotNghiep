package com.gymshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Order_Details")
public class OrderDetail {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_size_id")
	ProductSize productSize;

	@Column(name="price")
	Double price;
	
	@Column(name="quantity")
	int quantity;
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(Long id, Order order, ProductSize productSize, Double price, int quantity) {
		super();
		this.id = id;
		this.order = order;
		this.productSize = productSize;
		this.price = price;
		this.quantity = quantity;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public ProductSize getProductSize() {
		return productSize;
	}

	public void setProductSize(ProductSize productSize) {
		this.productSize = productSize;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotal() {
		return price * quantity;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", order=" + order + ", productSize=" + productSize + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}

	

}
