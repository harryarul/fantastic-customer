package com.util.ms.dto;

import java.util.List;
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

	private static ConcurrentHashMap<String, Customer> mapCustomers = new ConcurrentHashMap<String, Customer>();
	
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
		String cId = String.valueOf(custId);
		LOGGER.info("customer Id "+cId);
		if(mapCustomers.containsKey(cId)) {
			LOGGER.info("found customer ");
			customer = mapCustomers.get(cId);
		}
		return customer;
	}

	public List<Customer> getAllCustomers() {		
		return (List<Customer>) mapCustomers.values();
	}
	
	public void removeCustomer(Long custId) {

		if(mapCustomers.containsKey(String.valueOf(custId))) {
			mapCustomers.remove(String.valueOf(custId));
		}

	}
	
	public Customer updateCustomer(Customer customer) {
		LOGGER.info("Validated customer");
		String custId = String.valueOf(customer.getId());
		mapCustomers.replace(custId, mapCustomers.get(custId), customer);
		return customer;		
	}
}
