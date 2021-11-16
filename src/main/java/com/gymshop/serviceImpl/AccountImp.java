package com.gymshop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymshop.dao.AccountDAO;
import com.gymshop.entities.Account;
import com.gymshop.service.AccountService;

@Service
public class AccountImp implements AccountService{
	@Autowired
	AccountDAO accountDAO;

	@Override
	public Account checkAccount(String username, String password) {
		
		return accountDAO.checkAccount(username, password);
	}
	
		//admin
		@Override
		public Account getAccount(Long account_id) {
			// TODO Auto-generated method stub
			return accountDAO.findById(account_id).get();
		}
		
		@Override
		public List<Account> getAll() {
			// TODO Auto-generated method stub
			return accountDAO.findAll();
		}

		@Override
		public Account addAccount(Account account) {
			// TODO Auto-generated method stub
			return accountDAO.save(account);
		}

		@Override
		public Account updateAccount(Account account) {
			
			account = accountDAO.save(account);
			return account;
		}

		@Override
		public boolean deleteAccount(Long id) {
			
			Account account = accountDAO.getOne(id);
			if(account != null) {
				accountDAO.deleteById(id);
				return true;
			}
			return false;
		}

		@Override
		public Account checkAccountbyUsername(String username) {
			// TODO Auto-generated method stub
			return accountDAO.checkAccountbyUsername(username);
		}

		@Override
		public Account checkAccountAdmin(String username, String password) {
			// TODO Auto-generated method stub
			return accountDAO.checkAccountAdmin(username, password);
		}

		
	
	}

	
	
	

