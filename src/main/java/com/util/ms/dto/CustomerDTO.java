package com.util.ms.dto;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.util.ms.model.Customer;

/**
 * 
 * @author arul
 *
 */
@Service
public class CustomerDTO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDTO.class);

	ConcurrentHashMap<String, Customer> mapCustomers = new ConcurrentHashMap<String, Customer>();
	
	public CustomerDTO() {
		
	}
	
	public Customer createCustomer(Customer customer) {
		LOGGER.info("Validated customer");
		String custId = String.valueOf(customer.getId());
		if(!mapCustomers.contains(custId)) {
			mapCustomers.put(custId, customer);
		}
		
		return customer;
		
	}
	
	public Customer getCustomer(Long custId) {
		
		Customer customer = new Customer();
		if(mapCustomers.contains(String.valueOf(custId))) {
			customer = mapCustomers.get(String.valueOf(custId));
		}
		return customer;
	}

	public void removeCustomer(Long custId) {

		if(mapCustomers.contains(String.valueOf(custId))) {
			mapCustomers.remove(String.valueOf(custId));
		}

	}
}
