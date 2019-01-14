package com.etonghk.killrate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.etonghk.killrate.dao")
public class KillRateApplication {
	public static void main(String[] args) {
		SpringApplication.run(KillRateApplication.class, args);
	}
}
