package com.gymshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gymshop.entities.*;

@Repository
public interface AccountDAO extends JpaRepository<Account, Long> {
	@Query(value="select * from account where username = UPPER(:username) and password= UPPER(:password)", nativeQuery =true)
	Account checkAccount(@Param("username") String username, @Param("password") String passord);
	
	//admin
	@Query(value="select * from account where username = UPPER(:username)", nativeQuery =true)
	Account checkAccountbyUsername(@Param("username") String username);
	
	@Query(value="select * from account where username = UPPER(:username) and password= UPPER(:password) and admin = 1", nativeQuery =true)
	Account checkAccountAdmin(@Param("username") String username, @Param("password") String passord);
	
}
