package com.evan.lms.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

import org.apache.commons.lang.StringUtils;

import com.evan.lms.dao.UserDao;
import com.evan.lms.entity.User;

public class UserDaoImpl implements UserDao {
	@PersistenceContext
	
	private EntityManager em;
	
	public void updateUser(User user) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		if(StringUtils.isNotEmpty(user.getName())){
//			cb.equal("", y)
		}
	}

}
