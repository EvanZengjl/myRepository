package com.evan.lms.service.impl;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.evan.lms.BaseTest;
import com.evan.lms.entity.Role;
import com.evan.lms.entity.User;
import com.evan.lms.service.UserService;

public class UserServiceImplTest extends BaseTest {

	
	@Autowired
	private UserService userService;
	
	@Test
	public void testAddUser() {
		User u = new User("dfodhfoh", "fdsofif", "fdsdd", "1380025443", "dgge",2);
		
		userService.addUser(u);
	}

	@Test
	public void testDeleteUserById() {
		userService.deleteUserById(2);
	}
	

	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setName("你大爷的");
		user.setId(10);
		userService.updateUser(user);
	}
//	@Test
//	public void testUpdateUser() {
//		User user = new User("装神弄鬼", "费哦哦", "eww4ww345", "13222323122", "大佛的hi佛号", 2);
//		user.setId(9);
//		userService.updateUser(user);
//	}

	@Test
	public void testFindUserList() {
		List<User> list=userService.findUserList();
		for (User u : list) {
			System.out.println("*******");
			System.out.println("id:"+u.getId());
			System.out.println("userName:"+u.getName());
			System.out.println("RoleNum:"+u.getRoleNum());
//			Set<Role> roles = u.getRoles();
//			for(Role role : roles){
//				System.out.println("RoleName:"+role.getName());
//			}
			System.out.println("*******");
		}
	}

	@Test
	public void testGetUserByNameAndPassword() {
		fail("Not yet implemented");
	}
	@Test
	public void testGetUserByName() {
		User user = userService.getUserByName("aa");
		System.out.println("====================");
		System.out.println(user.getName());
		System.out.println(user.getDescription());
		System.out.println(user.getId());
		System.out.println("====================");
	}

	@Test
	public void testGetUserById() {
		User user = userService.getUserById(2);
		System.out.println(user.getId());
		System.out.println(user.getName());
		System.out.println(user.getNickName());
	}

}
