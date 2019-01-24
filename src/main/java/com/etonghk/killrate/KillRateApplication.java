package com.etonghk.killrate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.jack.pool.impl.DataFactoryImpl;

@SpringBootApplication
@MapperScan(basePackages = "com.etonghk.killrate.dao")
@Import(DataFactoryImpl.class)
public class KillRateApplication {
	public static void main(String[] args) {
		SpringApplication.run(KillRateApplication.class, args);
	}
}