package com.evan.lms.service;

import java.util.List;

import com.evan.lms.entity.User;

public interface UserService {
	
	
	public int addUser(User user);
	public int updateUser(User user);
	public void deleteUserById(int id);
	public List<User> findUserList();
	public User getUserByNameAndPassword(String name,String password);
	public User getUserByName(String name);
	public User getUserById(int id);

}
