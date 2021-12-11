package com.gymshop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymshop.dao.AccountDAO;
import com.gymshop.entities.Account;
import com.gymshop.service.accountService;
@Service
public class accountsServiceImpl implements accountService{
	@Autowired
	AccountDAO aDao;
	@Override
	public Account findById(String username) {
		// TODO Auto-generated method stub
		return aDao.findById(username).get();
	}

	@Override
	public List<Account> getAdministrators() {
		
		return null;
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return aDao.findAll();
	}

	@Override
	public Account create(Account account) {
		// TODO Auto-generated method stub
		return aDao.save(account);
	}

	@Override
	public Account update(Account account) {
		// TODO Auto-generated method stub
		return aDao.save(account);
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		aDao.deleteById(username);
	}

	@Override
	public Long getCount() {
		
		return aDao.count();
	}

	@Override
	public void save(Account acc) {
		 aDao.save(acc);
		
	}

	

	
}
