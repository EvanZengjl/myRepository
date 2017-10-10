package com.evan.lms.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.evan.lms.validate.annotation.RoleCheck;
import com.sun.istack.internal.NotNull;


@Entity(name="t_role")
@RoleCheck
public class Role implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="role_num",nullable=false)
	private int roleNum;
	
//	@NotNull
	private String name;
	
	private String remark;
//	
//	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "user")
//	private Set<User> users = new HashSet<User>();
//	

	public Role() {
		super();
	}

	

	public Role(int roleNum, String name, String remark) {
		super();
		this.roleNum = roleNum;
		this.name = name;
		this.remark = remark;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}



	public int getRoleNum() {
		return roleNum;
	}



	public void setRoleNum(int roleNum) {
		this.roleNum = roleNum;
	}



//	public Set<User> getUsers() {
//		return users;
//	}
//
//
//
//	public void setUsers(Set<User> users) {
//		this.users = users;
//	}
//	
	
	
	
	
}
