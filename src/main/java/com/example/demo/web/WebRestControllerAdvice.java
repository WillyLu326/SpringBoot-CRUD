package com.example.demo.web;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exception.CustomNotFoundException;
import com.example.model.ResponseMsg;

@RestControllerAdvice
public class WebRestControllerAdvice {

	@ExceptionHandler(CustomNotFoundException.class)
	public ResponseMsg handleNotFoundException(CustomNotFoundException ex) {
		ResponseMsg msg = new ResponseMsg(ex.getMessage());
		return msg;
	}
}
