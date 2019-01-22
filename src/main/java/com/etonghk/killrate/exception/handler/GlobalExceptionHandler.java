package com.etonghk.killrate.exception.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.etonghk.killrate.controller.dto.ApiResult;
import com.etonghk.killrate.exception.ServiceException;
import com.google.gson.Gson;

/**
 * @author Billy.Yu
 * @date 2019年1月21日
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ExceptionHandler(value= {Exception.class})
	public String test(Exception ex, HttpServletRequest req, HttpServletResponse resp, Model model) throws IOException{
		
		String errMsg = "";
		if (ex instanceof ServiceException) {
			errMsg = ex.getMessage();
		}else {
			logger.error("Error Msg:", ex);
			errMsg = "服务器内部错误";								
		}
		
		if("XMLHttpRequest".equals(req.getHeader("X-Requested-With"))
				|| "application/json".equals(req.getHeader("Content-type"))) {
			Gson gson = new Gson();
			ApiResult<Void> result = new ApiResult<Void>();
			result.setCode(ApiResult.FAILD_CODE);
			result.setMsg(errMsg);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(gson.toJson(result));
			return null;
		}else {
			model.addAttribute("msg", errMsg);
		}
		return "/error";
	}
	
}
