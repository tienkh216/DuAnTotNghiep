package com.gymshop.dao;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gymshop.entities.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {

	@Query(value = "select * from order_details where OrderId =:id" , nativeQuery =true)
    List<OrderDetail> findByOrderId(@Param("id") Long id);

}
