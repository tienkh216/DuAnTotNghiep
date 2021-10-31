package com.gymshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gymshop.entities.*;

@Repository
public interface ProductSizeDAO extends JpaRepository<ProductSize, Long> {
	@Query(value="select * from product_size where product_id = :id", nativeQuery =true)
	 List<ProductSize> findByIdProSize(@Param("id") Long id);
}
