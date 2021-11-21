package com.gymshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymshop.entities.Authority;

public interface AuthorityDao extends JpaRepository<Authority, Integer> {

}
