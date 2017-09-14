package com.example.exception;

public class CustomNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -7946854717044734471L;

	public CustomNotFoundException(String msg) {
		super(msg);
	}
	
}
