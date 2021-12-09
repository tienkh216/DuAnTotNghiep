package com.gymshop.controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.gymshop.entities.Order;
import com.gymshop.service.orderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/test/checkout")
public class OrderListCreate {
	@Autowired
	orderService orderService;
	
	@PostMapping()
	public Order create(@RequestBody JsonNode orderData) {


		return orderService.create(orderData);
		
	}
}
