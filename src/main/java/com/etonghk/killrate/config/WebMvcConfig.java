package com.etonghk.killrate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.etonghk.killrate.config.formatter.DateFormatter;
import com.etonghk.killrate.interceptor.LoginInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
		.excludePathPatterns("/error","/js/**","/bootstrap/**","/css/**")
		.addPathPatterns("/**")
		;
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new DateFormatter());
	}
}
