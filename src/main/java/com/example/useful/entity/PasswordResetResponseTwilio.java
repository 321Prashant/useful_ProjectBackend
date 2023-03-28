package com.example.useful.entity;

public class PasswordResetResponseTwilio {

	private OtpStatus status;
	private String message;
	
	
	
	public PasswordResetResponseTwilio() {
		super();
	}

	public PasswordResetResponseTwilio(OtpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public OtpStatus getStatus() {
		return status;
	}

	public void setStatus(OtpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
