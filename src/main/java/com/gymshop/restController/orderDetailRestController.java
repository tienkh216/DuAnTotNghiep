package com.gymshop.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymshop.entities.Order;
import com.gymshop.entities.OrderDetail;
import com.gymshop.service.orderDetailService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orderdetail")
public class orderDetailRestController {
	@Autowired
	orderDetailService orderDetailService;
	
	@GetMapping()
	public List<OrderDetail> getAll(){
		return orderDetailService.findAll();
	}
	@GetMapping("{id}")
	public List<OrderDetail> getOne(@PathVariable("id") Long id) {
			return orderDetailService.findByOrderId(id);
	}
	
}
