package com.evan.lms.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="t_news")
public class News {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String title;
	
	@Column(name="ref_url")
	private String refUrl;
	
	private String content;
	
	@Column(name="created_time")
	private Timestamp createdTime;
	
	private Integer times;
	
	public News() {
		super();
	}

	public News(String title, String refUrl, String content, Timestamp createdTime) {
		super();
		this.title = title;
		this.refUrl = refUrl;
		this.content = content;
		this.createdTime = createdTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRefUrl() {
		return refUrl;
	}

	public void setRefUrl(String refUrl) {
		this.refUrl = refUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}
	
	
	

}
