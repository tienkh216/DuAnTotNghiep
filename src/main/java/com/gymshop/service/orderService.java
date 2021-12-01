package com.gymshop.service;

import java.util.List;

import com.gymshop.entities.Order;

public interface orderService {
	List<Order> findAll();
	Order findById (Long id);
	
}
