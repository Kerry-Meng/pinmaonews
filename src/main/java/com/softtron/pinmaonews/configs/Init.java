package com.softtron.pinmaonews.configs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@MapperScan("com.softtron.pinmaonews.daos")
@ComponentScan(basePackages = {"com.softtron.pinmaonews"})
public class Init {
	
	public static void main(String[] args) {
		SpringApplication.run(Init.class, args);
	}
}
