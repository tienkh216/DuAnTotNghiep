package com.gymshop.service;

import java.util.List;

import com.gymshop.entities.Category;
import com.gymshop.entities.Product;

public interface productService {

	List<Product> findByCategoryId(String string);

	List<Product> findAll();

	Product findById(Long id);

	Product create(Product product);

	Product update(Product product);

	void delete(Long id);

	List<Product> findTopProductWithCreateDate();

	List<Product> findTopProductWithProductStatus(String productStatus);


	List<Category> getCategoryId();
}
