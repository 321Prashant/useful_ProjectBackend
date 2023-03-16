package com.example.useful.CustomExceptionHadling;

public class ControllerException extends RuntimeException {

	private Integer errorCode;
	private String errorMessage;
	
	
	
	
	public  ControllerException() {
		super();
	}
	
	public ControllerException(Integer errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
