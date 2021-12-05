package com.gymshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gymshop.entities.*;


@Repository
public interface CategoryDAO extends JpaRepository<Category, Long> {
	 @Query(value = "SELECT a.*" +
	            "FROM f_report_category_by_year(:year) a " +
	            "ORDER BY a.quantity desc ",
	            nativeQuery = true)
	    List<Object> report(int year);
	 
	 
	 @Query(value = "SELECT * \r\n"
		 		+ " FROM (select db.price * db.quantity as 'tong', MONTH(b.order_date) as 'thang' \r\n"
		 		+ " from order_detail db, [order] b where b.id = db.order_id and b.order_status_id = 1 and YEAR(b.order_date) = :year ) a \r\n"
		 		+ " pivot( sum(tong) for thang in ([1], [2], [3], [4], [5], [6], [7], [8], [9], [10], [11], [12]) ) as pvtMonth", nativeQuery = true)
		    List<Object> TotalInYear(int year);



	 @Query(value = "select c.* from Categories c, Products p\n" +
			 "where c.id = p.category_id \n" +
			 "and p.category_id in (select top(20) category_id \n" +
			 "                    from Products\n" +
			 "                    order by id desc)\n" +
			 "group by c.id, c.name",nativeQuery = true)
		List<Category> getCategory();
}
