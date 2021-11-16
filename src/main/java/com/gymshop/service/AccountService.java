package com.gymshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gymshop.entities.Account;
@Service
public interface AccountService {
	Account checkAccount(String username, String password);
	
	//admin
		public Account getAccount(Long account_id);
		
		public List<Account> getAll();
		
		public Account addAccount(Account account);
		
		public Account updateAccount(Account account);
					
		public boolean deleteAccount(Long id);
		
		Account checkAccountbyUsername(String username);
		
		Account checkAccountAdmin(String username, String password);
		
	
}
