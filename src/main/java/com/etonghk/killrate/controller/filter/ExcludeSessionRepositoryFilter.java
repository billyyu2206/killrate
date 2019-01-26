package com.etonghk.killrate.controller.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author Ami.Tsai
 * @date 2019年1月25日
 */
@Component
@Order(Integer.MIN_VALUE)
public class ExcludeSessionRepositoryFilter extends OncePerRequestFilter{

	static List<String> excludeSessionUrls = new ArrayList<>();
	static {
		excludeSessionUrls.add("/betRecord/send");
		excludeSessionUrls.add("/awardNumber/clearKillRate");
		excludeSessionUrls.add("/gameIssus/job/batchInsert");
		excludeSessionUrls.add("/gameIssus/job/selectOpenIssue");
		excludeSessionUrls.add("/cache/reset");
		excludeSessionUrls.add("/killrateSetting/switch");
		excludeSessionUrls.add("/killrateSetting/changeSwitch");
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
			FilterChain filterChain) throws ServletException, IOException {
		String uri = httpRequest.getRequestURI();
		
		if (excludeSessionUrls.contains(uri)) {
			httpRequest.setAttribute("org.springframework.session.web.http.SessionRepositoryFilter.FILTERED", Boolean.TRUE);
		}
		filterChain.doFilter(httpRequest, httpResponse);
	}
}
