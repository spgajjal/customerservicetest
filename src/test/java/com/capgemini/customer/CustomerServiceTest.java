package com.capgemini.customer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.customer.entity.Customer;
import com.capgemini.customer.exception.AuthenticationFailedException;
import com.capgemini.customer.exception.CustomerNotFoundException;
import com.capgemini.customer.repository.CustomerRepository;
import com.capgemini.customer.service.impl.CustomerServiceImpl;




@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CustomerServiceTest {
	
	@Mock
	private CustomerRepository customerRepository;
	
	@InjectMocks
	
	private CustomerServiceImpl customerServiceImpl;
	
	
	Customer customer=new Customer(1, "spandhana","spandhu","sp@gmail.com");
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void addCustomerTest() {
		when(customerRepository.save(Mockito.isA(Customer.class))).thenReturn(customer);
		System.out.println(customer);
		Customer result = customerServiceImpl.addCustomer(customer);
		System.out.println(result);
		assertEquals(customer, result);
	}
	
	@Test
	public void updateCustomerTest() {
		System.out.println(customer);
		customer.setCustomerName("Tejasree");
		when(customerRepository.save(Mockito.isA(Customer.class))).thenReturn(customer);
		System.out.println(customer);
		assertEquals(customer, customerServiceImpl.updateCustomer(customer));
	}
	
	@Test
	public void testFindcustomerById() throws Exception {
		System.out.println(customer.getCustomerId());
		
		Optional<Customer> optionalCustomer = Optional.of(customer);
		when(customerRepository.findById(Mockito.isA(Integer.class))).thenReturn(optionalCustomer);
		
		System.out.println(customer.getCustomerId() + "for" + customer);
		assertEquals(optionalCustomer.get(), customerServiceImpl.findCustomerById(1234));
	}

	@Test
	public void TestForDeletecustomer() throws Exception {
		System.out.println(customer);
		customerServiceImpl.deleteCustomer(customer);
		verify(customerRepository).delete(customer);
		System.out.println(customer);
	}
	
	
	

}