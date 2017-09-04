package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.model.Code;

@Service
public class CodeServiceHelper {

	@Autowired
	MongoOperations mongoOperations;
	
	public void saveCode() {
		Code code = new Code();
		code.setName("Add Node");
		code.setContent("node two");
		this.mongoOperations.save(code);
	}
	
	public List<Code> getCode() {
		return this.mongoOperations.findAll(Code.class);
	}
	
	public Code getOneCode(String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		return this.mongoOperations.findOne(query, Code.class);
	}
	
	public Code deleteByName(String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		return this.mongoOperations.findAndRemove(query, Code.class);
	}
	
	
	
}
