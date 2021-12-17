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
	public Object findById(Long id) {
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
	public void cancelOrder(Long id) {
		orderDao.cancelOrder(id);
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

	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper=new ObjectMapper();
		  
		  Order order=mapper.convertValue(orderData, Order.class); 
		  orderDao.save(order);
		  
		  TypeReference<List<OrderDetail>> type=new TypeReference<List<OrderDetail>>(){};
		  List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
				  .stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
		  orderDtailDao.saveAll(details);
		  return order;
	}

	@Override
	public List<Order> getOrderListByUsername(String username) {
		
		return orderDao.getOrderListByUsername(username);
	}

	@Override
	public List<Order> getCancelOrderListByUsername(String username) {
		
		return orderDao.getCancelOrderListByUsername(username);
	}

	@Override
	public Long getSuccessOrder() {
		// TODO Auto-generated method stub
		return orderDao.getSuccessOrder();
	}

	@Override
	public List<Integer> getYearOrder() {
		// TODO Auto-generated method stub
		return orderDao.getYearOrder();
	}

	

	
	

}
