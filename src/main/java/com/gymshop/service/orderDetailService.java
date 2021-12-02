package com.gymshop.service;

import java.util.List;

import com.gymshop.entities.OrderDetail;

public interface orderDetailService {
	List<OrderDetail> findAll();
	OrderDetail findById (Long id);
	
	List<OrderDetail> findByOrderId(Long id);
}
