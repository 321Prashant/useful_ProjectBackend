package com.example.useful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Test")
public class Test {
	
	@GetMapping("/Check")
	public String checking() {
		return "working app";
	}
	
}
