package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Code;

@RestController
public class CodeService {
	
	@Autowired
	private CodeServiceHelper codeServiceHelper;
	
	@RequestMapping("/")
	public String home() {
		return "Hello world";
	}
	
	@RequestMapping(value="/codes", method=RequestMethod.GET)
	public List<Code> getAll() {
		return this.codeServiceHelper.getCode();
	}
	
	@RequestMapping(value="/codes", method=RequestMethod.POST)
	public List<Code> saveCode(@RequestBody Code code) {
		return this.codeServiceHelper.saveCode(code);
	}
	
	@RequestMapping("/codes/{name}")
	public Code getOneCode(@PathVariable("name") String name) {
		return this.codeServiceHelper.getOneCode(name);
	}
	
	@RequestMapping("/request")
	public String getPathRequest(@RequestParam("code") String name) {
		//http://localhost:8080/request?code=xxx
		return name;
	}
	
	@RequestMapping("/codes/delete/{name}")
	public Code removeCodeByName(@PathVariable("name") String name) {
		return this.codeServiceHelper.deleteByName(name);
	}
	
	@RequestMapping("/codes/update/{name}")
	public Code updateCodeByName(@PathVariable("name") String name, @RequestParam("content") String updatedContent) {
		return this.codeServiceHelper.updateByName(name, updatedContent);
	}
}
