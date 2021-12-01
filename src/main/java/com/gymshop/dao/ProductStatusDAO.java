package com.gymshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymshop.entities.ProductStatus;

@Repository
public interface ProductStatusDAO extends JpaRepository<ProductStatus, Long> {
}
