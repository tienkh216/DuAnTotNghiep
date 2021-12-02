package com.gymshop.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.gymshop.entities.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {
	
	
}
