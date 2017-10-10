package com.evan.lms.service;

import java.util.List;

import com.evan.lms.entity.Role;

public interface RoleService {
	
	public int addRole(Role role);
	
	public int updateRole(Role role);
	
	public void deleteRoleById(int id);

	public List<Role> findRoleList();
	
	public Role getRoleById(int id);
	
	public Role getRoleByName(String name);
	
}
