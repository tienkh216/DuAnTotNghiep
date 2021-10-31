package com.gymshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gymshop.entities.*;


@Repository
public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {
	@Query(value="select * from order_detail join [order] on order_detail.order_id = [order].id where [order].account_id = :acc_id and [order].order_status_id " ,nativeQuery =true)
	List<OrderDetail> getProductByIdAccount(@Param("acc_id") Long account_id); 
	
	//admin
		/*@Query(value = "select d.order_id as order_id, a.fullname as fullname, o.order_date as order_date, a.address as address, "+
				 "s.description as description, sum(d.quantity) as sumQuantity,sum(d.price*d.quantity) as total "+
				 "from [order] o join order_detail d on o.id = d.order_id "+
				 "join account a on a.id = o.account_id "+
				 "join order_status s on s.id = o.order_status_id "+
				 "group by d.order_id, a.fullname, o.order_date, s.description, a.address ", nativeQuery = true)
		List<OrderDTO> viewAllOrder();
		
		@Query(value = "select * from order_detail  where order_id = :o_id", nativeQuery = true)
		List<OrderDetail> getOrderDetail(@Param("o_id") int id_order);*/
}
