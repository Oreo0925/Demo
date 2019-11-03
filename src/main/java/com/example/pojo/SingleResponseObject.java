package com.example.pojo;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.Collection;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.example.exception.CustmerException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.example.util.Constants;

public class SingleResponseObject<Object> implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean success = true;

	private String message = "";
	
	private String errorMessage = "";

	@JsonInclude(Include.NON_NULL)
	private Object data;

	private int total = 0;

	private Integer code = 200; // error code

	private String stackTrace = "";

	public SingleResponseObject() {
		super();
	}

	public SingleResponseObject(Object data) {
		this.data = data;
	}

	public static SingleResponseObject<?> error(Integer code, Exception e) {
		SingleResponseObject<?> sro = new SingleResponseObject<>();
		sro.setSuccess(false);
		sro.setErrorMessage(e.getMessage());
		sro.setCode(code);
		sro.setStackTrace(e);
		return sro;
	}

	public void setErrorMessage(CustmerException e) {
		this.success = e.isSuccess();
		this.code = e.getCode();
		this.errorMessage = e.getErrorMessage();
		setStackTrace(e);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object objects) {
		this.message = "OK";
		if (objects != null) {
			total = 1;
			if (objects instanceof Collection) {
				total = ((Collection<?>) objects).size();
				if (total == 0) {
					this.message = Constants.NODATA;
				}
			}
		}
		this.data = objects;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setStackTrace(Exception e) {
		String str = ExceptionUtils.getStackTrace(e);
		str = str.replaceAll("\r\n\tat", "<br/>"); 
		this.stackTrace = str;
	}

	public String getStackTrace() {
		return this.stackTrace;
	}
}
