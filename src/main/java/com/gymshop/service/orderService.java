package com.gymshop.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.gymshop.entities.Order;

public interface orderService {
	List<Order> findAll();
	
	List<Order> getOrderListByUsername(String username);
	
	List<Order> getCancelOrderListByUsername(String username);
	

	Object findById(Long id);

	Order update(Order order);

	void delete(Long id);
	
	void cancelOrder(Long id);
	
	

	Long getPendingOrder();
	Long getSuccessOrder();

	
	List<Order> findByUsername(String username);

	Order create(JsonNode orderData);

	
	
	List<Integer> getYearOrder();


   
}

