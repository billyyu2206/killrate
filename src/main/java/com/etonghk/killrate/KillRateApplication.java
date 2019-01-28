package com.etonghk.killrate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.etonghk.killrate.system.GracefulShutdown;
import com.jack.pool.impl.DataFactoryImpl;

@SpringBootApplication
@MapperScan(basePackages = "com.etonghk.killrate.dao")
@Import(DataFactoryImpl.class)
public class KillRateApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(KillRateApplication.class, args);
	}

	@Autowired
	private GracefulShutdown gracefulShutdown;

	@Bean
	public ServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		tomcat.addConnectorCustomizers(gracefulShutdown);
		return tomcat;
	}
}