package com.gymshop.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.gymshop.entities.Order;

public interface orderService {
	List<Order> findAll();
	
	Order findById (Long id);
	
	Order update(Order order);

	void delete(Long id);

	
	Long getPendingOrder();
	
	List<Order> findByUsername(String username);
}

