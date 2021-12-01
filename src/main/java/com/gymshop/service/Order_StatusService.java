package com.gymshop.service;

import java.util.List;

import com.gymshop.entities.OrderStatus;

public interface Order_StatusService {
	public OrderStatus getOrderStatus(Long id);
	
	//admin
		
		
		public List<OrderStatus> getAll();
		
		public OrderStatus addOrderStatus(OrderStatus orderStatus);
		
		public OrderStatus updateOrderStatus(OrderStatus orderStatus);
		
		public boolean deleteOrderStatus(Long id);
}
