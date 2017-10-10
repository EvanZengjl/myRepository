package com.evan.lms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="t_news_type")
public class NewsType {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String remark;
	
	private Boolean enable;
	
	

	public NewsType() {
		super();
	}



	public NewsType(String name, String remark) {
		super();
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



	public Boolean getEnable() {
		return enable;
	}



	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	
	
	

}
