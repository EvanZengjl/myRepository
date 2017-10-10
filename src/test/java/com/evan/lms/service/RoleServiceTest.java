package com.evan.lms.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.evan.lms.BaseTest;
import com.evan.lms.entity.Role;

public class RoleServiceTest extends BaseTest  {
	
	@Autowired
	private RoleService service;
	

	@Test
	public void testAddRole() {
		Role role = new Role(4,"qqqqeeeeqq","wq");
		service.addRole(role);
	}
	
	@Test
	public void testGetRoleByName() {
		Role role = service.getRoleByName("aa");
		System.out.println("=================");
		System.out.println(role.getName());
		System.out.println(role.getId());
		System.out.println("=================");
	}

	@Test
	public void testDeleteRoleById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindRoleList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRoleById() {
		fail("Not yet implemented");
	}

}
