package com.example.useful.entity;

import javax.persistence.Entity;

public class PasswordRequestTwilio {

	private String userName;
	private String number;
	private String oneTimePasswordTwilio;
	
	
	public PasswordRequestTwilio() {
	}
	
	public PasswordRequestTwilio(String userName, String number, String oneTimePasswordTwilio) {
		super();
		this.userName = userName;
		this.number = number;
		this.oneTimePasswordTwilio = oneTimePasswordTwilio;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getOneTimePasswordTwilio() {
		return oneTimePasswordTwilio;
	}
	public void setOneTimePasswordTwilio(String oneTimePasswordTwilio) {
		this.oneTimePasswordTwilio = oneTimePasswordTwilio;
	}
	
	
}
