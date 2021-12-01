package com.gymshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymshop.entities.OrderStatus;

@Repository
public interface OrderStatusDAO extends JpaRepository<OrderStatus, Long> {
}
