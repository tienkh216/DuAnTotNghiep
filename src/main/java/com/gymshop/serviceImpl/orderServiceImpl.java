package com.gymshop.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gymshop.dao.OrderDAO;
import com.gymshop.dao.OrderDetailDAO;
import com.gymshop.entities.Order;
import com.gymshop.entities.OrderDetail;
import com.gymshop.service.orderService;

@Service
public class orderServiceImpl implements orderService {
	@Autowired
	OrderDAO orderDao;
	
	@Autowired
	OrderDetailDAO orderDtailDao;
	
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

	@Override
	public Order update(Order order) {
		// TODO Auto-generated method stub
		return orderDao.save(order);
	}

	@Override
	public void delete(Long id) {
		orderDao.deleteById(id);
		
	}


	@Override
	public Long getPendingOrder() {
		// TODO Auto-generated method stub
		return orderDao.getPendingOrder();
	}

	@Override
	public List<Order> findByUsername(String username) {
		return orderDao.findByUsername(username);
	}

	



}
