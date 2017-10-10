package com.evan.lms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evan.lms.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	

	public Role findRoleByName(String name);
}
