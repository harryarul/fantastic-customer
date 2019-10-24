package com.util.ms.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.util.ms.dto.CustomerDTO;
import com.util.ms.model.Customer;
import com.util.ms.security.JwtUser;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-22T02:04:45.001Z")

/**
 * 
 * @author arul
 *
 */
@RestController
@Api(value = "customer", description = "the customer API")
@PreAuthorize("hasRole(@jWTRoles.getRoles())")
public class CustomerApiController  {

    private static final Logger log = LoggerFactory.getLogger(CustomerApiController.class);

    private final HttpServletRequest request;
    
    @Autowired
    private CustomerDTO customerDto;

    @org.springframework.beans.factory.annotation.Autowired
    public CustomerApiController(HttpServletRequest request) {
        this.request = request;
    }
    
    @ApiOperation(value = "Create customer", nickname = "createCustomer", notes = "This can only be done by the Authorized customer.", response = Customer.class, tags={ "customer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Customer.class),
        @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/customer",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,  
        method = RequestMethod.POST)
    ResponseEntity<Customer> createCustomer(@ApiParam(value = "Created customer object" ,required=true )  @Valid @RequestBody Customer customerRequest) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		JwtUser userDetails = (JwtUser) authentication.getPrincipal();
		
		log.info("User [{}] ", userDetails.getUsername());
    	
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	log.info("Header " + accept);
            	log.info("Customer [{}] " + customerRequest.getFirstName());
            	customerDto.createCustomer(customerRequest);
            	return new ResponseEntity<Customer>(customerRequest, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Customer>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "Delete customer", nickname = "deleteCustomer", notes = "This can only be done by the logged in customer.", tags={ "customer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "Invalid customer Id supplied"),
        @ApiResponse(code = 404, message = "Customer not found") })
    @RequestMapping(value = "/customer/{custId}",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteCustomer(@ApiParam(value = "The customer that needs to be deleted",required=true) @PathVariable("custId") Long custId) {
    	customerDto.removeCustomer(custId);

        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "Get customer by customer Id", nickname = "getCustomerByName", notes = "", response = Customer.class, tags={ "customer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Customer.class),
        @ApiResponse(code = 400, message = "Invalid customer Id supplied"),
        @ApiResponse(code = 404, message = "Customer not found") })
    @RequestMapping(value = "/customer/{custId}",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE, 
        method = RequestMethod.GET)
    ResponseEntity<Customer> getCustomerByName(@ApiParam(value = "The name that needs to be fetched. Use user1 for testing.",required=true) @PathVariable("custId") Long custId) {
        String accept = request.getHeader("Accept");
        List<Customer> listCustomer = new ArrayList<Customer>();
        Customer customer = new Customer();
        if (accept != null && accept.contains("application/json")) {
            try {
            	log.info("Header " + accept);
            	if(custId != null) {
            		customer = customerDto.getCustomer(custId);
            		listCustomer.add(customer);
            	} else {
            		listCustomer = customerDto.getAllCustomers();
            	}
            	
            	return new ResponseEntity<Customer>(customer, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Customer>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "Update customer", nickname = "updateCustomer", notes = "This can only be done by the logged in customer.", response = Customer.class, tags={ "customer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Customer.class),
        @ApiResponse(code = 400, message = "Invalid customer user supplied"),
        @ApiResponse(code = 404, message = "Customer not found") })
    @RequestMapping(value = "/customer/{custId}",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE, 
        method = RequestMethod.PUT)
    ResponseEntity<Customer> updateCustomer(@ApiParam(value = "customer Id that need to be updated",required=true) @PathVariable("custId") Long custId,@ApiParam(value = "Update customer object" ,required=true )  @Valid @RequestBody Customer customer) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	customerDto.updateCustomer(customer);
                return new ResponseEntity<Customer>(customer, HttpStatus.NOT_IMPLEMENTED);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Customer>(HttpStatus.NOT_IMPLEMENTED);
    }

}
