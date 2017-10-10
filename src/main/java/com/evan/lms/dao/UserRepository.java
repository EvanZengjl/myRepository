package com.evan.lms.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.evan.lms.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findUserByNameAndPassword(String name,String password);
	public User findUserByName(String name);
	
	public User findUserById(int id);

//	public Specification<User> findAll(Specification<User> specification);
	
}
