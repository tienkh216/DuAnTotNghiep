package com.gymshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymshop.entities.Role;

public interface RoleDao extends JpaRepository<Role, String> {

}
