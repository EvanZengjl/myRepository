package com.evan.lms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evan.lms.dao.NewsTypeRepository;
import com.evan.lms.entity.News;
import com.evan.lms.entity.NewsType;
import com.evan.lms.service.NewsTypeService;


@Service
public class NewsTypeServiceImpl implements NewsTypeService {

	@Autowired
	private NewsTypeRepository newsTypeRepository;
	
	
	public int addNewsType(NewsType newsType) {
		NewsType type = newsTypeRepository.save(newsType);
		return type.getId();
	}

	public int updateNewsType(NewsType newsType) {
		return 0;
	}

	public void deleteNewsTypeById(int id) {
		newsTypeRepository.delete(id);

	}

	public List<NewsType> findNewsType() {
		return newsTypeRepository.findAll();
	}

	public NewsType getNewsTypeById(int id) {
		return  newsTypeRepository.getOne(id);
	}

}
