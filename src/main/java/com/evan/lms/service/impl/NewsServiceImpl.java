package com.evan.lms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evan.lms.dao.NewsRepository;
import com.evan.lms.entity.News;
import com.evan.lms.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {
 
	@Autowired
	private NewsRepository newsRepository;
	
	public int addNews(News news) {
		News n = newsRepository.saveAndFlush(news);
		return n.getId();
	}

	public int updateNews(News news) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void deleteNewsById(int id) {
		newsRepository.delete(id);

	}


	public List<News> findNewsList() {
		return newsRepository.findAll();
	}

	public News getNewsById(int id) {
		return newsRepository.getOne(id);
	}


}
