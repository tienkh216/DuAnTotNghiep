package com.gymshop.service;

import java.util.List;

import com.gymshop.entities.Product;

public interface productService {

	List<Product> findByCategoryId(String string);

	List<Product> findAll();

}
