package com.gymshop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymshop.dao.AccountDAO;
import com.gymshop.dao.AuthorityDao;
import com.gymshop.entities.Account;
import com.gymshop.entities.Authority;
import com.gymshop.service.authotiryService;
@Service
public class authorityServiceImpl implements authotiryService {
	@Autowired
	AuthorityDao authorityDao;
	@Autowired
	AccountDAO accountDao;

	@Override
	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> accounts=accountDao.getAdministrators();
		return authorityDao.authoritiesOf(accounts);
	}

	@Override
	public List<Authority> findAll() {
		// TODO Auto-generated method stub
		return authorityDao.findAll();
	}

	@Override
	public Authority create(Authority auth) {
		// TODO Auto-generated method stub
		return authorityDao.save(auth);
	}

	@Override
	public void delete(Integer id) {
		authorityDao.deleteById(id);
	}

}
