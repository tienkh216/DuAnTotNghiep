package com.gymshop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymshop.dao.RoleDao;
import com.gymshop.entities.Role;
import com.gymshop.service.roleService;
@Service
public class roleServiceImpl implements roleService{
	@Autowired
	RoleDao rdao;
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return rdao.findAll();
	}

}
