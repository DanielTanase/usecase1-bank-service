package com.danieltns.bank.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptions {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationEx(MethodArgumentNotValidException ex) {
		Map<String, String> responseBody = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach(err -> {
			String field = ((FieldError) err).getField();
			String message = err.getDefaultMessage();
			responseBody.put(field,  message);
		});
		
		return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Map<String, String>> handleDataViolationEx(DataIntegrityViolationException ex) {
		Map<String, String> responseBody = new HashMap<>();
		responseBody.put("message", ex.getMostSpecificCause().getMessage());
		
		return new ResponseEntity<>(responseBody, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Map<String, String>> handleIllegalArgumentEx(IllegalArgumentException ex) {
		Map<String, String> responseBody = new HashMap<>();
		responseBody.put("message", ex.getMessage());
		
		return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
	}
}
