package com.evan.lms.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.evan.lms.dao.UserRepository;
import com.evan.lms.entity.User;
import com.evan.lms.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	
	@Autowired
	private UserRepository userRepository;

	public int addUser(User user) {
		User u = userRepository.save(user);
		return u.getId();
	}

	public int updateUser(User user) {
		User u = userRepository.saveAndFlush(user);
		return u.getId();
	}

	

	public void deleteUserById(int id) {
		userRepository.delete(id);
	}

//	@Cacheable(value="user",keyGenerator="keyGenerator")
	public List<User> findUserList() {
		System.out.println("进入查询");
		return userRepository.findAll();
	}

	public User getUserByNameAndPassword(String name,String password) {
		
		return userRepository.findUserByNameAndPassword(name, password);
	}
	
//	@Cacheable(value="user",keyGenerator="keyGenerator")
	public User getUserByName(String name) {
		System.out.println("进入查询");
		return userRepository.findUserByName(name);
	}

	public User getUserById(int id) {
		return userRepository.findUserById(id);
	}

}
