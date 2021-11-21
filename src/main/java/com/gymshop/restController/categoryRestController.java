package com.gymshop.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymshop.entities.Category;
import com.gymshop.service.categoryService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categories")
public class categoryRestController {
	@Autowired
	categoryService categoryService;
	@GetMapping()
	public List<Category> getAll(){
		return categoryService.findAll();
	}
	
}
