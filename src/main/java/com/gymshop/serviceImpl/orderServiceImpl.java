package com.gymshop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymshop.dao.OrderDAO;
import com.gymshop.entities.Order;
import com.gymshop.service.orderService;
@Service
public class orderServiceImpl implements orderService {
	@Autowired
	OrderDAO orderDao;
		
	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return orderDao.findAll();
	}

	@Override
	public Order findById(Long id) {
		// TODO Auto-generated method stub
		return orderDao.findById(id).get();
	}

}
