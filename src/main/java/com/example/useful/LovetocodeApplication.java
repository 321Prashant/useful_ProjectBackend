package com.example.useful;

import java.util.Collections;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.useful.Configuration.TwilioConfig;
import com.twilio.Twilio;

@SpringBootApplication
@RestController
public class LovetocodeApplication {

	@Autowired
	private TwilioConfig twilioConfig;

	@PostConstruct
	public void initTwilio(){
		Twilio.init(twilioConfig.getAccountSid(),twilioConfig.getAuthToken());
	}
//	   @GetMapping("/user")
//	    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
//	        return Collections.singletonMap("name", principal.getAttribute("name"));
//	    }
	   
//	   @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	    	// @formatter:off
//	        http
//	            .authorizeRequests(a -> a
//	                .antMatchers("/", "/error", "/webjars/**").permitAll()
//	                .anyRequest().authenticated()
//	            )
//	            .exceptionHandling(e -> e
//	                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//	            )
//	            .oauth2Login();
//	        // @formatter:on
//	        
//	        http
//	           // ... existing code here
//	           .csrf(c -> c
//	               .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//	           )
//	    }
	
	public static void main(String[] args) {
		SpringApplication.run(LovetocodeApplication.class, args);
	}

}
