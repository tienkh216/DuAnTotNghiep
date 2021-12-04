package com.gymshop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymshop.dao.CategoryDAO;
import com.gymshop.entities.Category;
import com.gymshop.service.categoryService;
@Service
public class categoryServiceImpl implements categoryService{
	@Autowired
	CategoryDAO cdao;
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return cdao.findAll();
	}

	@Override
	public Category create(Category category) {
		// TODO Auto-generated method stub
		return cdao.save(category);
	}

	@Override
	public Category update(Category category) {
		// TODO Auto-generated method stub
		return cdao.save(category);
	}

	@Override
	public void delete(Long id) {
		cdao.deleteById(id);
		
	}

	@Override
	public Category findById(Long id) {
		// TODO Auto-generated method stub
		return cdao.findById(id).get();
	}

	@Override
	public List<Category> getCategory() {
		return cdao.getCategory();
	}

}
