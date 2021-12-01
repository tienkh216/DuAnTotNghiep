package com.gymshop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymshop.dao.OrderStatusDAO;
import com.gymshop.entities.OrderStatus;
import com.gymshop.service.Order_StatusService;

@Service
public class OrderStatusImp implements Order_StatusService{
	@Autowired
	OrderStatusDAO orderStatusDAO;

	@Override
	public OrderStatus getOrderStatus(Long id) {
		// TODO Auto-generated method stub
		return  orderStatusDAO.findById(id).get();
	}
	
	//admin
	
	@Override
	public List<OrderStatus> getAll() {
		// TODO Auto-generated method stub
		return orderStatusDAO.findAll();
	}

	@Override
	public OrderStatus addOrderStatus(OrderStatus orderStatus) {
		// TODO Auto-generated method stub
		return orderStatusDAO.save(orderStatus);
	}

	@Override
	public OrderStatus updateOrderStatus(OrderStatus orderStatus) {
		// TODO Auto-generated method stub
		orderStatus = orderStatusDAO.save(orderStatus);
		return orderStatus;
	}

	@Override
	public boolean deleteOrderStatus(Long id) {
		// TODO Auto-generated method stub
		OrderStatus orderStatus = orderStatusDAO.getOne(id);
		if(orderStatus != null) {
			orderStatusDAO.deleteById(id);
			return true;
		}
		return false;
	}
}
