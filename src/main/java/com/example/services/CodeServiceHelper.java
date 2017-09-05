package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.model.Code;

@Service
public class CodeServiceHelper {

	@Autowired
	MongoOperations mongoOperations;
	
	public List<Code> saveCode(Code code) {
		this.mongoOperations.save(code);
		return this.mongoOperations.findAll(Code.class);
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
	
	public Code updateByName(String name, String updatedContent) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		
		Update update = new Update();
		update.set("content", updatedContent);
		
		this.mongoOperations.upsert(query, update, Code.class);
		return this.mongoOperations.findOne(query, Code.class);
	}
	
}
