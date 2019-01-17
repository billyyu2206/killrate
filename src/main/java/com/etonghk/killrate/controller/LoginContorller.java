package com.etonghk.killrate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etonghk.killrate.domain.Account;
import com.etonghk.killrate.service.account.AccountService;

@Controller
public class LoginContorller {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AccountService accountService;

	@GetMapping("/")
	public String index(Account account) {
		logger.info("123");
		return "login";
	}

	@PostMapping("/loginAcc")
	public String login(Account account, Model model, HttpServletRequest request) {
		HttpSession session =  request.getSession();
		 request.getRemoteAddr();
		try {
			model.addAttribute("errorMsg", null);
			String ip = getFisrtRemoteHost(request);
			account = accountService.login(account.getAccount(), account.getPassword(),ip);
			session.setAttribute(session.getId(), account);
		} catch (RuntimeException e) {
			model.addAttribute("errorMsg", "帳號密碼錯誤");
			return "login";
		} catch (Exception e) {
			model.addAttribute("errorMsg", "錯誤");
			return "login";
		}

		return "redirect:/killRate";
	}
	
	
	private String getRemoteHost(HttpServletRequest request){
	    String ip = request.getHeader("x-forwarded-for");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
	        ip = request.getHeader("X-FORWARDED-FOR");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
	        ip = request.getHeader("X-Forwarded-For");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
	        ip = request.getHeader("Proxy-Client-IP");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
	        ip = request.getRemoteAddr();
	    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	}//method 
	
	private String getFisrtRemoteHost(HttpServletRequest request){
	 
		String ip = getRemoteHost(request);
	    
	    if(ip != null){
	    	String[] array = ip.split(",");
	    	if(array.length > 0){
	    		ip = array[0];
	    	}
	    }
	    
	    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	}//method 
	
	@RequestMapping("logOut")
	public String logOut(HttpSession session) {
		session.removeAttribute(session.getId());
		return "redirect:/";
	}

}
