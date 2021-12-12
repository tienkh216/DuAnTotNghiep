package com.gymshop.service;

import java.util.List;

import com.gymshop.entities.Authority;

public interface authotiryService {
	public List<Authority> findAuthoritiesOfAdministrators();

	public	List<Authority> findAll();

	public	Authority create(Authority auth);

	public void delete(Integer id);
}
