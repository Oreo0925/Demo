package com.example.enums;

public enum CustmerEnum {
	NO_DATA_ERROR(204, "查無資料", true);
	
	private Integer code;
	private String errorMessage;
	private boolean success;
	
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

	CustmerEnum(Integer code, String errorMessage, boolean success) {
        this.code = code;
        this.errorMessage = errorMessage;
        this.success = success;
    }
}
