package com.example.services;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.model.Customer;

@Service
public class CustomerService {

	Map<String, Customer> custStorage = new HashMap<>();
	
	@PostConstruct
	void init() {
		Customer jack = new Customer("Jack", 20);
		Customer peter = new Customer("Peter", 30);
		custStorage.put("Jack", jack);
		custStorage.put("Peter", peter);
	}
	
	public Customer findCustomerByName(String name) {
		return custStorage.get(name);
	}
}
