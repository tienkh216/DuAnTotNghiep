package com.gymshop.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymshop.domain.Top10;
import com.gymshop.entities.Product;
import com.gymshop.service.productService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/chart")
public class chartRestController {
	@Autowired
	productService productService;
	
	@GetMapping()
	public List<Top10> getAll(){
		return productService.top10product();
	}
	
}
