package com.etonghk.killrate.controller.dto;

/**
 * 
 * @author Billy
 *
 */
public class ApiResult<T>{
	public static final String SUCCESS_CODE = "200";
	public static final String FAILD_CODE = "500";
	
	private T data;
	private String code;
	private String msg;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
