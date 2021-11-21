package com.gymshop.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.gymshop.entities.Order;

public interface OrderService {

	Order create(JsonNode orderData);

	Object findById(Long id);

	List<Order> findByUsername(String username);

}
