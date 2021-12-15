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
	@GetMapping("{id}")
	public Category getOne (@PathVariable("id") Long id) {
		return categoryService.findById(id);
	}
	
	@PostMapping()
	public Category create(@RequestBody Category category) {
		return categoryService.create(category);
	}
	
	@PutMapping("{id}")
	public  Category update(@PathVariable("id") Long id , @RequestBody Category category) {
		return categoryService.update(category);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		categoryService.delete(id);
	}
	
}
