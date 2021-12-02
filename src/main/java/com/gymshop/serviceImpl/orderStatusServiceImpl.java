package com.gymshop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymshop.dao.OrderStatusDAO;
import com.gymshop.entities.OrderStatus;
import com.gymshop.service.orderStatusService;
@Service
public class orderStatusServiceImpl implements orderStatusService {
	@Autowired
	OrderStatusDAO dao;
	
	@Override
	public List<OrderStatus> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
