package com.example.cqxt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.cqxt.mapper")
public class CqxtApplication {

	public static void main(String[] args) {
		SpringApplication.run(CqxtApplication.class, args);
	}

}
