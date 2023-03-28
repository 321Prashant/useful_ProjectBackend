package com.example.useful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.useful.Handler.TwilioOtpHandler;

@Component
//@RequestMapping("/twilioOtpTest")
public class TwilioOtpController {


    @Autowired
    private TwilioOtpHandler handler;

    @Bean
    public RouterFunction<ServerResponse> handleSMS() {
        return RouterFunctions.route()
                .POST("/router/sendOTP", handler::sendOTP)
                .POST("/router/validateOTP", handler::validateOTP)
                .build();
    }
}
