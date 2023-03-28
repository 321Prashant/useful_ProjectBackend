package com.example.useful.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.useful.entity.EmailOTP;
import com.example.useful.entity.Users;
import com.example.useful.service.EmailOTPService;

//Authentication failed; nested exception is javax.mail.AuthenticationFailedException: 535-5.7.8 Username and Password not accepted.
@RestController
@RequestMapping("/emailOTP")
public class EmailOTPController {
	
	@Autowired
	EmailOTPService emailOTPService;

	@PostMapping("/sendingOTP")
	public String sendingOTPViaEmail(@RequestBody EmailOTP emailOtp) throws MessagingException {
		
		String OtpSent = emailOTPService.sendOTPViaEmail(emailOtp);
		return OtpSent;
		
	}
	
	@GetMapping("checkOtp/{otp}")
	public String checkingOTPViaEmail(@RequestBody Users user, @PathVariable String otp) {
		
		
		
		String OtpSent = emailOTPService.sendOTPViaEmail(user,otp);
		return OtpSent;
		
	}
	
}
