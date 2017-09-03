package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeService {
	
	@Autowired
	private CodeServiceHelper codeServiceHelper;
	
	@RequestMapping("/")
	public String home() {
		this.codeServiceHelper.saveCode();
		return "Hello world";
	}

}
