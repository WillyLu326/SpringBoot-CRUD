package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import com.example.model.Code;

@Component
public class CodeServiceHelper {

	@Autowired
	MongoOperations mongoOperations;
	
	public void saveCode() {
		Code code = new Code();
		code.setName("strStr");
		code.setContent("not sure");
		this.mongoOperations.save(code);
	}
}
