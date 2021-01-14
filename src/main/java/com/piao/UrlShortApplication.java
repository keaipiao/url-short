package com.piao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.piao.mapper")
public class UrlShortApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlShortApplication.class, args);
	}

}
