package com.softtron.pinmaonews.services;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtron.pinmaonews.daos.NewsDao;
import com.softtron.pinmaonews.domains.TNews;

@Service
public class NewsService {
	
	@Autowired
	NewsDao newsDao;
	
	public int insertNews(Map map) {
		return newsDao.insertNews(map);
	}
	
	public int updateNews(Map map) {
		return newsDao.updateNews(map);
	}
	
	//查询
	public Set<TNews> findAllNews(Map map) {
		return newsDao.findAllNews(map);
	}
	
	//删除操作
	public int deleteNews(int newsId) {
		return newsDao.deleteNews(newsId);
	}
	
}
