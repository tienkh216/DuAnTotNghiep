package com.gymshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gymshop.entities.*;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long> {
	
	@Query(value= "select * from [order] where account_id = :a_id and order_status_id = 2", nativeQuery =true)
	Order getoderbyId(@Param("a_id") Long account_id );

}
