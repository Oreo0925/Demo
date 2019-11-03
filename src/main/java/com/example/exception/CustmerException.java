package com.example.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.enums.CustmerEnum;

public class CustmerException extends Exception {
	private static final long serialVersionUID = 1L;
	private final static Logger logger = LoggerFactory.getLogger(CustmerException.class);
	private Integer code;
	private String errorMessage = "";
	private boolean success;

	public CustmerException(String message) {
		super(message);
	}

	public CustmerException(CustmerEnum error) {
		this.code = error.getCode();
		this.errorMessage = error.getErrorMessage();
		this.success = error.isSuccess();
		logger.debug(error.getErrorMessage());
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
