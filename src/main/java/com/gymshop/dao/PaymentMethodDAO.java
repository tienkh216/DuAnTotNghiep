package com.gymshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymshop.entities.PaymentMethod;

@Repository
public interface PaymentMethodDAO extends JpaRepository<PaymentMethod, Long> {
}
