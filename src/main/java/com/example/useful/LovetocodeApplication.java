package com.example.useful;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.useful.Configuration.TwilioConfig;
import com.twilio.Twilio;

@SpringBootApplication
public class LovetocodeApplication {

	@Autowired
	private TwilioConfig twilioConfig;

	@PostConstruct
	public void initTwilio(){
		Twilio.init(twilioConfig.getAccountSid(),twilioConfig.getAuthToken());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LovetocodeApplication.class, args);
	}

}
