package com.capgemini.customer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.customer.controller.CustomerController;
import com.capgemini.customer.entity.Customer;
import com.capgemini.customer.service.CustomerService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)

public class CustomerControllerTest {
	
	@Mock
	CustomerService customerService;
	
	@InjectMocks
	CustomerController customerController;
	
	private MockMvc mockMvc;
	  
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	
	@Test
	public void testcustomerWhichAddCustomerTest() throws Exception {
		Customer customer=new Customer(1, "spandhana","spandhu","sp@gmail.com");
		when(customerService.addCustomer(Mockito.isA(Customer.class))).thenReturn(customer);
		mockMvc.perform(post("/customer").contentType(MediaType.APPLICATION_JSON_UTF8).content(
				"{\"customerId\":\"1\",\"customerName\":\"spandhana\",\"customerPassword\":\"spandhu\",\"customerEmail\":\"sp@gmail.com\"}")
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print());

		
	
	
	
}
	@Test
	public void testcustomerWhichUpdateCustomerTest() throws Exception {
		Customer customer=new Customer(1, "spandhana","spandhu","sp@gmail.com");
		when(customerService.updateCustomer(Mockito.isA(Customer.class))).thenReturn(customer);
		when(customerService.findCustomerById(1)).thenReturn(customer);
		
		mockMvc.perform(put("/customer").contentType(MediaType.APPLICATION_JSON_UTF8).content(
				"{\"customerId\":\"1\",\"customerName\":\"spandhu\",\"customerPassword\":\"spandhu\",\"customerEmail\":\"sp@gmail.com\"}")
				.accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andDo(print());


	
	
}

}