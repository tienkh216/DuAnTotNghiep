package com.gymshop.service;

import java.util.List;

import com.gymshop.entities.Account;

public interface accountService {
	Account findById(String id);

	List<Account> getAdministrators();

	List<Account> findAll();

	Account create(Account account);
	Account update(Account account);
	void delete (String id);
	
}
