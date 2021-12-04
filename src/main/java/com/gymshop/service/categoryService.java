package com.gymshop.service;

import java.util.List;

import com.gymshop.entities.Category;

public interface categoryService {
	List<Category> findAll();

	Category create(Category category);

	Category update(Category category);

	void delete(Long id);

	Category findById(Long id);

	List<Category> getCategory();
}
