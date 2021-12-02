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

import com.gymshop.entities.Product;
import com.gymshop.entities.ProductStatus;
import com.gymshop.service.productService;
import com.gymshop.service.productStatusService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class productControllerRest {
	@Autowired
	productService productService;
	@Autowired
	productStatusService productStatusService;
	
	@GetMapping("status")
	public  List<ProductStatus>getStatus() {
			return productStatusService.findAll();
	}
	
	@GetMapping()
	public  List<Product>getAll() {
			return productService.findAll();
	}
	
	@GetMapping("{id}")
	public Product getOne(@PathVariable("id") Long id) {
			return productService.findById(id);
	}
	
	@PostMapping
	public Product create(@RequestBody Product product) {
			return productService.create(product);
	}
	
	@PutMapping("{id}")
	public Product update(@PathVariable("id") Integer id,@RequestBody Product product) {
			return productService.update(product);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
			 productService.delete(id);
	}
}
