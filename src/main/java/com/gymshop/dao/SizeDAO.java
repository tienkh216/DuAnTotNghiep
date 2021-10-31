package com.gymshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymshop.entities.*;

public interface SizeDAO extends JpaRepository<Size, Long> {
}
