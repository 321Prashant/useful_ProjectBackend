package com.example.useful.service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.useful.Configuration.TwilioConfig;
import com.example.useful.entity.OtpStatus;
import com.example.useful.entity.PasswordRequestTwilio;
import com.example.useful.entity.PasswordResetResponseTwilio;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import reactor.core.publisher.Mono;

@Service
public class TwilioOtpService {

	@Autowired
	private TwilioConfig twilioConfig;
	
	Map<String, String> otpMap = new HashMap<>();

    public Mono<PasswordResetResponseTwilio> sendOTPForPasswordReset(PasswordRequestTwilio passwordRequestTwilio) {
    	
    	PasswordResetResponseTwilio passwordResetResponseDto = null;
    	
    	try {
    		PhoneNumber to = new PhoneNumber(passwordRequestTwilio.getNumber());
            PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
            String otp = generateOTP();
            String otpMessage = "Dear Customer , Your OTP is ##" + otp + "##. Use this Passcode to complete your transaction. Thank You.";
            Message message = Message
                    .creator(to, from,
                            otpMessage)
                    .create();
            otpMap.put(passwordRequestTwilio.getUserName(), otp);
            passwordResetResponseDto = new PasswordResetResponseTwilio(OtpStatus.DELIVERED, otpMessage);
    	}
    	catch (Exception e) {
    		  passwordResetResponseDto = new PasswordResetResponseTwilio(OtpStatus.FAILED, e.getMessage());
        }
        return Mono.just(passwordResetResponseDto);
    }
    
    private String generateOTP() {
        return new DecimalFormat("000000")
                .format(new Random().nextInt(999999));
    }
    
    
    public Mono<String> validateOTP(String userInputOtp, String userName) {
        if (userInputOtp.equals(otpMap.get(userName))) {
            otpMap.remove(userName,userInputOtp);
            return Mono.just("cool verified you are");
        } else {
            return Mono.error(new IllegalArgumentException("Invalid otp please retry !"));
        }
    }
    
  }
