package com.softtron.pinmaonews.daos;

import java.util.LinkedHashSet;
import java.util.Map;

import com.softtron.pinmaonews.domains.TNews;

public interface NewsDao {
	
	//插入新闻
	public int insertNews(Map map);
	
	//更新新闻
	public int updateNews(Map map);
	
	//查询新闻
	public LinkedHashSet<TNews> findAllNews(Map map);
	
	//删除数据,根据Id进行删除
	public int deleteNews(int newsId);
}
