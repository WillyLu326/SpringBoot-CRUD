package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.CustomNotFoundException;
import com.example.model.Customer;

@RestController
public class WebController {

	@Autowired
	CustomerService consumerService;
	
	@RequestMapping("/customer")
	public String hello() {
		return "Hello Customer";
	}
	
	@RequestMapping(value = "/customer/{name}", method = RequestMethod.GET)
	public Customer findCustomerByName(@PathVariable("name") String name) {
		Customer customer = this.consumerService.findCustomerByName(name);
		
		if (customer == null) {
			throw new CustomNotFoundException("Not found customer with name " + name);
		}
		
		return customer;
	}
}
