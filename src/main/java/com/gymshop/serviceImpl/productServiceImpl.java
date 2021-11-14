package com.gymshop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymshop.dao.ProductDAO;
import com.gymshop.entities.Product;
import com.gymshop.service.productService;

@Service
public class productServiceImpl implements productService{
	@Autowired
	ProductDAO dao;

	@Override
	public List<Product> findByCategoryId(String string) {
		// TODO Auto-generated method stub
		return dao.findProductByCategory(string);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Product findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public Product create(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
}
