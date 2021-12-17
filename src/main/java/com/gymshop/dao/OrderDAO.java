package com.gymshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.gymshop.entities.Order;

public interface OrderDAO extends JpaRepository<Order, Long> {
	
	@Query(value = "select count(*) from Orders where order_status_id = 1" , nativeQuery =true)
	Long getPendingOrder();
	
	@Query(value = "select count(*) from Orders where order_status_id = 4" , nativeQuery =true)
	Long getSuccessOrder();
	
	@Query(value = "SELECT * from Orders where Username =:username",nativeQuery =true)
	List<Order> findByUsername(@Param("username") String username);
	
	@Transactional
	@Modifying
	@Query("update Order o set o.orderStatus = 5 where o.id=:id ")
	void cancelOrder(@Param("id") Long id);
	
	
	@Query(value = "select * from Orders where order_status_id != 5 and Username =:username",nativeQuery =true)
	List<Order> getOrderListByUsername(String username);
	
	@Query(value = "select * from Orders where order_status_id = 5 and Username =:username",nativeQuery =true)
	List<Order> getCancelOrderListByUsername(String username);
	
	@Query(value = "select  Year(od.CreateDate)\r\n"
			+ "from  Orders od\r\n"
			+ "group by Year(od.CreateDate)",nativeQuery =true)
	List<Integer> getYearOrder();
	
}
