package com.softtron.pinmaonews.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtron.pinmaonews.services.NewsService;

@RestController
public class RouterController extends CommonController {
	
	@Autowired
	NewsService newsService;
	
	/**
	 * 进行插入，在插入成功之后，会返回主键Id
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(path = "/insertnews")
	public Object insertNews(@RequestBody(required = false) Map map) {
		Map news = (Map) map.get("news");
		// 如果等于-1，则进行插入
		if (Integer.parseInt(String.valueOf(map.get("newId"))) == -1) {
			newsService.insertNews(map);
			// 插入成功之后，将newId进行返回
			resultMap.put("newId", newsService.insertNews(map));
		} else {
			newsService.updateNews(map);
		}
		return resultMap;
	}
	
	@RequestMapping(path = "/findallnews/{page}/{count}")
	public Map findAllNews(@PathVariable(name = "page") int page, @PathVariable(name = "count") int count) {
		// 将获取的page,count,放入集合中
		Map map = new HashMap();
		map.put("start", (page - 1) * count);
		map.put("count", count);
		// 将查询出来的信息进行返回
		resultMap.put("news", newsService.findAllNews(map));
		return resultMap;
	}
	
	@RequestMapping(path = "/deletenews/{newsId}")
	public Map deleteNews(@PathVariable int newsId) {
		resultMap.put("newId", newsService.deleteNews(newsId));
		return resultMap;
	}
	
}
