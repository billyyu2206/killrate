package com.etonghk.killrate.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

@Configuration
public class LoginInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static List<String> allowUrls = new ArrayList<String>();
	static {
		allowUrls.add("/loginAcc");
		allowUrls.add("/");
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String requestUrl = request.getRequestURI();
		
		for(String url : allowUrls) {
			if(requestUrl.endsWith(url)) {
				return true;
			}
		}
		
		if (session.getAttribute(session.getId()) != null) {
			return true;
		}
		logger.info("account is null");
        String url = "/";
        response.sendRedirect(url);
		return false;
	}
}
