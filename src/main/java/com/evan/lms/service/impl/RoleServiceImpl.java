package com.evan.lms.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evan.lms.dao.RoleRepository;
import com.evan.lms.entity.Role;
import com.evan.lms.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	
	public int addRole(@Valid Role role) {
		Role r = roleRepository.saveAndFlush(role);
		return r.getId();
	}

	public int updateRole(Role role) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void deleteRoleById(int id) {
		roleRepository.delete(id);

	}

	public List<Role> findRoleList() {
		return roleRepository.findAll();
	}
	
	

	public Role getRoleById(int id) {
		return roleRepository.getOne(id);
	}

	public Role getRoleByName(String name) {
		return roleRepository.findRoleByName(name);
	}
	
	


}
