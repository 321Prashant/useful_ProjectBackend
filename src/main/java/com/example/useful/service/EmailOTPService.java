package com.example.useful.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.useful.entity.EmailOTP;
import com.example.useful.entity.Users;
import com.example.useful.repository.EmailOTPRepository;
import com.example.useful.repository.UsersRepository;


//Authentication failed; nested exception is javax.mail.AuthenticationFailedException: 535-5.7.8 Username and Password not accepted.
@Service
public class EmailOTPService {

//	@Autowired
//	Users user;
	@Autowired
	EmailOTPRepository emailOTPRepository;
	@Autowired
	UsersRepository userRepository;
	
	 @Autowired 
	 private JavaMailSender javaMailSender;
	 
	 @Value("${spring.mail.username}") 
	 private String sender;
	
	public String sendOTPViaEmail(EmailOTP emailOtp) {
		
	    String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	            + "0123456789"
	            + "abcdefghijklmnopqrstuvxyz";
	    
	     StringBuilder sb = new StringBuilder(10);
	    
	     for (int i = 0; i < 10; i++) {
	    
	      int index
	       = (int)(AlphaNumericString.length()
	         * Math.random());
	    
	      sb.append(AlphaNumericString
	         .charAt(index));
	     }
	    sb.toString();
		System.out.print(sb);
		// Creating a simple mail message
        SimpleMailMessage mailMessage
            = new SimpleMailMessage();
        
//        MimeMessage msg = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        
        // Setting up necessary details
        mailMessage.setFrom(sender);
        mailMessage.setTo("123shuklaprashant@gmail.com");
        mailMessage.setText(emailOtp.getMessage()+" otp is:"+sb);
        mailMessage.setSubject("This OTP will expire in 10 mins");

        // Sending the mail
        javaMailSender.send(mailMessage);
        System.out.print("Sending email in progress");
        
		try {
			Date date =  new Date();
	        emailOtp.setOneTimePassword(sb.toString());
	        emailOtp.setDate(date);
            emailOTPRepository.save(emailOtp);
            return "OTP sent bro!! Please check";
        }
 
        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
		
	}

	public String sendOTPViaEmail(Users user, String otp) {
		List<Integer> emailObject = userRepository.findAllEmailOfUser(user.getUserId());
		for(Integer emailIds:emailObject) {
			
			String nonNullEmailIdOtp = emailOTPRepository.findEmailWithNotNullOtp(emailIds);
			if(!nonNullEmailIdOtp.isEmpty()) {
				if(otp.equals(nonNullEmailIdOtp) && otpValidation(emailIds)) {
					return "Otp matched";
				}
				else 
					return "Sorry ur timed out or wrong otp sent";
			}
			
		}
		
		return "User have not applied for any otp ,, try again";
	}
	public boolean otpValidation(Integer emailIds) {
		 final long otpValidationDuration = 5* 60 * 1000;
		if(emailOTPRepository.findByDate(emailIds) + otpValidationDuration < System.currentTimeMillis()) {
			return true;
		}
		return false;
	}
	
	

}
