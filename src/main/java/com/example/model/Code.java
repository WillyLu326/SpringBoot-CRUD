package com.example.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class Code implements Serializable{
	
	private static final long serialVersionUID = 1515067058106013493L;

	@Id
	private String id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String content;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Code [id=" + id + ", name=" + name + ", content=" + content + "]";
	}
	
	
	
}
