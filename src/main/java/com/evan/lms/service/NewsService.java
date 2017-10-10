package com.evan.lms.service;

import java.util.List;

import com.evan.lms.entity.News;

public interface NewsService {
	
	public int addNews(News news);
	
	public int updateNews(News news);

	public void deleteNewsById(int id);
	
	public List<News> findNewsList();
	
	public News getNewsById(int id);
}
