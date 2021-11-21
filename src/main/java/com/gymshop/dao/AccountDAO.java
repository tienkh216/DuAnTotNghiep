package com.gymshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymshop.entities.Account;

public interface AccountDAO extends JpaRepository<Account, String> {

}
