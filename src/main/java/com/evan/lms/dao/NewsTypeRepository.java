package com.evan.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evan.lms.entity.NewsType;

public interface NewsTypeRepository extends JpaRepository<NewsType, Integer> {

}
