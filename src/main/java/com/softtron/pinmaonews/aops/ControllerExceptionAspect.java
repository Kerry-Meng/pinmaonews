package com.softtron.pinmaonews.aops;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softtron.pinmaonews.exceptions.CommonException;


@ControllerAdvice
public class ControllerExceptionAspect {
	public static final Logger logger = (Logger) LogManager.getLogger(ControllerExceptionAspect.class);

	@Bean(name = "resultmap")
	@Scope("prototype")
	public Map getResultMap() {
		Map map = new HashMap<>();
		map.put("code", "200");
		map.put("message", "操作成功!");
		return map;
	}

	@ExceptionHandler(value = Throwable.class)
	@ResponseBody
	public Object getException(Throwable e) {
		Map<String, String> map = getResultMap();

		if (e instanceof CommonException) {
			CommonException ce = (CommonException) e;
			map.put("code", ce.getCode());
			map.put("message", ce.getDetail());
		} else {
			map.put("code", "500");
			map.put("message", "操作失败");
		}
		logger.error(e.toString());
		e.printStackTrace();
		Map resultMap = new HashMap();
		resultMap.put("resultmap", map);
		return resultMap;
	}
}
