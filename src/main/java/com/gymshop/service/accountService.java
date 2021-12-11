package com.gymshop.service;

import java.util.List;

import com.gymshop.entities.Account;

public interface accountService {
	Account findById(String username);

	List<Account> getAdministrators();

	List<Account> findAll();

	Account create(Account account);
	Account update(Account account);
	void delete (String username);
	
	Long getCount();

	void save(Account acc);

	
}
