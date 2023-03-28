package com.example.useful.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
//Authentication failed; nested exception is javax.mail.AuthenticationFailedException: 535-5.7.8 Username and Password not accepted.tity
public class EmailOTP {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer emailOTP;
	
	
	private String message;
	private Date date;
	private String oneTimePassword;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private Users user;

	
	
	
	public EmailOTP(String message, Date date, String oneTimePassword, Users user) {
		super();
		this.message = message;
		this.date = new Date();
		this.oneTimePassword = oneTimePassword;
		this.user = user;
	}

	public Integer getEmailOTP() {
		return emailOTP;
	}

	public void setEmailOTP(Integer emailOTP) {
		this.emailOTP = emailOTP;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOneTimePassword() {
		return oneTimePassword;
	}

	public void setOneTimePassword(String oneTimePassword) {
		this.oneTimePassword = oneTimePassword;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
