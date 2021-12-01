package com.gymshop.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymshop.entities.Order;
import com.gymshop.service.orderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class orderRestController {
	@Autowired
	orderService orderService;
	
	@GetMapping()
	public List<Order> getAll(){
		return orderService.findAll();
	}
}
