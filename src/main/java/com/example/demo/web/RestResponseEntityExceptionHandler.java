package com.example.demo.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	public RestResponseEntityExceptionHandler() {
		System.out.println("==========================");
		System.out.println("==========================");
		System.out.println("==========================");
		System.out.println("==========================");
		System.out.println("==========================");
		System.out.println("==========================");
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex,
			final HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("==========================");
		System.out.println("==========================");
		System.out.println("==========================");
		System.out.println("==========================");
		System.out.println("==========================");
		System.out.println("==========================");
		System.out.println("==========================");
		return handleExceptionInternal(ex, "There is a problem", headers, HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ Exception.class })
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("==========================");
		System.out.println("==========================");
		System.out.println("==========================");
		System.out.println("==========================");
		System.out.println("==========================");
		System.out.println("==========================");
		System.out.println("==========================");
		return handleExceptionInternal(ex, "There is a problem", headers, HttpStatus.BAD_REQUEST, request);
	}
	
	
	@ExceptionHandler({ Exception.class })
	public void notFount(){
	    System.out.println("----------CaughtApplicationException-----------");
	}
	
}
