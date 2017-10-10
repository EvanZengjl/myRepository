package com.evan.lms.service;

import java.util.List;

import com.evan.lms.entity.NewsType;

public interface NewsTypeService {
	
	public int addNewsType(NewsType newsType);
	
	public int updateNewsType(NewsType newsType);

	public void deleteNewsTypeById(int id);
	
	public List<NewsType> findNewsType();
	
	public NewsType getNewsTypeById(int id);
}
