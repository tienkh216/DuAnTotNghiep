package com.gymshop.service;

import java.util.List;

import com.gymshop.domain.DoanhThuThang;
import com.gymshop.domain.Top10;
import com.gymshop.entities.Category;
import com.gymshop.entities.Product;

public interface productService {
	 

	List<Product> findByCategoryId(String string);
	
	public List<Product> listAll(String keyword) ;

	List<Product> findAll();

	Product create(Product product);

	Product update(Product product);

	void delete(Long id);

	List<Product> findTopNewProduct();

	List<Product> findTopProductWithProductStatus(String productStatus);


	List<Category> getCategoryId();


	Product findById(Long id);
	
	List<Top10> top10product();
	
	List<DoanhThuThang> doanhThuThang(int year);

}
