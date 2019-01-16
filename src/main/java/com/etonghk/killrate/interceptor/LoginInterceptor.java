package com.etonghk.killrate.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

@Configuration
public class LoginInterceptor implements HandlerInterceptor {

	private static List<String> allowUrls = new ArrayList<String>();
	static {
		allowUrls.add("/index");
		allowUrls.add("/login");
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
		System.out.println("account is null");
        String url = "/login";
        response.sendRedirect(url);
		return false;
	}
}
