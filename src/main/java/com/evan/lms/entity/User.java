package com.evan.lms.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@Entity(name="t_user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Length(min=6,max=20,message="用户名长度为6-20个字符串")
	private String name;
	
	@Column(name="nick_name")
	@Length(min=6,max=20,message="姓名长度为6-20个字符串")
	private String nickName;
	
	@Length(min=6,max=20,message="密码长度为6-20个字符串")
//	@Pattern(regexp="^[a-z]|[A-Z]|[0-9]|/_*$",message="密码不符合规范")
	private String password;
	
	@Pattern(regexp="^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$",message="手机号码不符合规范")
	private String phone;
	
	private String description;
	
	@Column(name="role_num",insertable=true,updatable=true,nullable=true)
	
	private int roleNum;
	
	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="last_login_time")
	private Timestamp lastLoginTime;
	
	@Column(name="last_operate_time")
	private Timestamp lastOperateTime;
 
	private String token;
	
	private Boolean enable;
	
	
	@ManyToOne(fetch=FetchType.LAZY,cascade={CascadeType.DETACH})
	@JoinColumn(name="role_num",referencedColumnName="role_num",foreignKey=@ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT),insertable=false,updatable=false)
	private Role role;
	
	
	

	public User() {
		super();
	}

	

	public User(String name, String nickName, String password, String phone, String description, int roleNum) {
		super();
		this.name = name;
		this.nickName = nickName;
		this.password = password;
		this.phone = phone;
		this.description = description;
		this.roleNum = roleNum;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Timestamp getLastOperateTime() {
		return lastOperateTime;
	}

	public void setLastOperateTime(Timestamp lastOperateTime) {
		this.lastOperateTime = lastOperateTime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}



	public int getRoleNum() {
		return roleNum;
	}



	public void setRoleNum(int roleNum) {
		this.roleNum = roleNum;
	}




	




	


	
	
	

	
	
}
