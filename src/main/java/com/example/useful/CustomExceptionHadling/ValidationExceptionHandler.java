package com.example.useful.CustomExceptionHadling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidationExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidException(MethodArgumentNotValidException ex){
		Map<String,String> mapExceptionHandler = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			mapExceptionHandler.put(error.getField(), error.getDefaultMessage());
		});
		return mapExceptionHandler;
	}
	
}
