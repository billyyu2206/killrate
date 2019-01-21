package com.etonghk.killrate.exception;

/**
 * @author Billy.Yu
 * @date 2019年1月21日
 */
@SuppressWarnings("serial")
public class ServiceException extends RuntimeException {

	public ServiceException() {
	}

	public ServiceException(String paramString) {
		super(paramString);
	}

	public ServiceException(Throwable paramThrowable) {
		super(paramThrowable);
	}

	public ServiceException(String paramString, Throwable paramThrowable) {
		super(paramString, paramThrowable);
	}

}
