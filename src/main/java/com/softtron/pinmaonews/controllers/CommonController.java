package com.softtron.pinmaonews.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CommonController {
	
	@Autowired
	@Qualifier("resultmap")
	Map<String,Object> resultMap;
	
}
