package com.evan.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evan.lms.entity.News;

public interface NewsRepository extends JpaRepository<News, Integer> {

}
 