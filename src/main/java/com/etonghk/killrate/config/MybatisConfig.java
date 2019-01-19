/**
 * 
 */
package com.etonghk.killrate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.etonghk.killrate.dao.interceptor.PageInterceptor;
import com.etonghk.killrate.dao.page.Dialect;

/**
 * @author Peter.Hong
 * @date 2019年1月18日
 */
@Configuration
public class MybatisConfig {

	@Autowired
	@Qualifier("mySqlDialect")
	Dialect dialect;

	@Bean
	public PageInterceptor pageInterceptor() {
		PageInterceptor pageInterceptor = new PageInterceptor();
		pageInterceptor.setDialect(dialect);

		return pageInterceptor;
	}
}
