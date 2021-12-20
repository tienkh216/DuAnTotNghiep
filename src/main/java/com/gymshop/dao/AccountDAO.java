package com.gymshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gymshop.entities.Account;

public interface AccountDAO extends JpaRepository<Account, String> {
	@Query(value = "select a.* \r\n"
			+ "from Accounts a,Authorities au\r\n"
			+ "where a.username = au.username\r\n"
			+ "and (au.RoleId like 'DIRE' or au.RoleId like 'STAF' or au.RoleId like 'CUST')\r\n"
			+ "" , nativeQuery =true)
	List<Account> getAdministrators();
	
	@Query("SELECT count (c) FROM Account c WHERE c.email=?1")
	long countByEmail(String email);
}
