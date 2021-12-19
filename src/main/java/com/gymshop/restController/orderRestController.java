package com.gymshop.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.gymshop.entities.Order;
import com.gymshop.entities.OrderStatus;
import com.gymshop.entities.Product;
import com.gymshop.service.orderService;
import com.gymshop.service.orderStatusService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class orderRestController {
	@Autowired
	orderService orderService;
	@Autowired
	orderStatusService orderStatusService;
	
	@GetMapping("getYear")
	public List<Integer> getYear(){
		return orderService.getYearOrder();

	}
	
	@GetMapping("status")
	public List<OrderStatus> getStatus(){
		return orderStatusService.findAll();
	}
	
	@GetMapping("getPending")
	public Long getOrderPending(){
		return orderService.getPendingOrder();
	}
	@GetMapping("getSuccess")
	public Long getSuccess(){
		return orderService.getSuccessOrder();
	}
	@PostMapping
	public Order create(@RequestBody JsonNode orderData) {
		return orderService.create(orderData);
		
	}
	@GetMapping()
	public List<Order> getAll(){
		return orderService.findAll();
	}
	@GetMapping("{id}")
	public Object getOne(@PathVariable("id") Long id) {
			return orderService.findById(id);
	}
	
	@PutMapping("{id}")
	public Order update(@PathVariable("id") Integer id,@RequestBody Order order) {
			return orderService.update(order);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		orderService.delete(id);
	}	
	
	
}
