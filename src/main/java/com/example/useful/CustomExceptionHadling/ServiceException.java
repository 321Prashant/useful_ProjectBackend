package com.example.useful.CustomExceptionHadling;


public class ServiceException extends RuntimeException{

	private String errorCode;
	private String errorMessage;
	
	
	
	
	public ServiceException() {
		super();
	}
	public ServiceException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
