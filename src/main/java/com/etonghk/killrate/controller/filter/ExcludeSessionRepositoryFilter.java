package com.etonghk.killrate.controller.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.etonghk.killrate.controller.helper.ApiUriHelper;

/**
 * @author Ami.Tsai
 * @date 2019年1月25日
 */
@Component
@Order(Integer.MIN_VALUE)
public class ExcludeSessionRepositoryFilter extends OncePerRequestFilter{

	
	@Override
	protected void doFilterInternal(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
			FilterChain filterChain) throws ServletException, IOException {
		String uri = httpRequest.getRequestURI();
		
		if(ApiUriHelper.checkIsApiUri(uri)) {
			httpRequest.setAttribute("org.springframework.session.web.http.SessionRepositoryFilter.FILTERED", Boolean.TRUE);
		}
		
		filterChain.doFilter(httpRequest, httpResponse);
	}
}
