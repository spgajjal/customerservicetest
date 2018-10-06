package com.capgemini.customer.service;

import java.util.List;

import com.capgemini.customer.entity.Customer;
import com.capgemini.customer.exception.AuthenticationFailedException;
import com.capgemini.customer.exception.CustomerNotFoundException;

public interface CustomerService {
	public Customer authenticateCustomer(Customer customer)throws AuthenticationFailedException;
	
	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer findCustomerById(int customerId)throws CustomerNotFoundException;
	
	public void deleteCustomer(Customer customer);

	Customer authenticate(Customer customer) throws AuthenticationFailedException, CustomerNotFoundException;

	List<Customer> getAllCustomers();
	

}
