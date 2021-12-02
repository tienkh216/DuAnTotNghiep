package com.gymshop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymshop.dao.ProductStatusDAO;
import com.gymshop.entities.ProductStatus;
import com.gymshop.service.productStatusService;

@Service
public class productStatusServiceImpl implements productStatusService {
	@Autowired
	ProductStatusDAO dao;

	@Override
	public List<ProductStatus> findAll() {
		
		return dao.findAll();
	}

}
