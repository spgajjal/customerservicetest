package com.capgemini.customer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.customer.entity.Customer;
import com.capgemini.customer.exception.CustomerNotFoundException;
import com.capgemini.customer.service.CustomerService;

@RestController
public class CustomerController {
	
@Autowired
CustomerService customerService;

@PostMapping("/customer")
public ResponseEntity<Customer> addcustomer(@RequestBody Customer customer){
	
	ResponseEntity<Customer> responseEntity=new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.OK);
	return responseEntity;
	
}
@PutMapping("/customer")
public ResponseEntity<Customer> updatecustomer(@RequestBody Customer customer){
	try {
	Customer customerFromDb=customerService.findCustomerById(customer.getCustomerId());
	if(customerFromDb !=null)
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer),HttpStatus.OK);
	
	}
	catch(CustomerNotFoundException exception) {
		
	}
	return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
}
	
	
	
	

	
	
}






