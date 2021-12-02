package com.gymshop.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymshop.dao.OrderDetailDAO;

import com.gymshop.entities.OrderDetail;
import com.gymshop.service.orderDetailService;

@Service
public class OrderDetailServiceImpl implements orderDetailService {
	@Autowired
	OrderDetailDAO dao;

	@Override
	public List<OrderDetail> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public OrderDetail findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public List<OrderDetail> findByOrderId(Long id) {
		// TODO Auto-generated method stub
		return dao.findByOrderId(id);
	}

	

	
}
