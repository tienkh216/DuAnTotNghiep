package com.gymshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gymshop.entities.Order;

public interface OrderDAO extends JpaRepository<Order, Long> {
	
	@Query(value = "select count(*) from Orders where order_status_id = 1" , nativeQuery =true)
	Long getPendingOrder();
	
	@Query(value = "SELECT * from Orders where Username =:username",nativeQuery =true)
	List<Order> findByUsername(@Param("username") String username);
}
