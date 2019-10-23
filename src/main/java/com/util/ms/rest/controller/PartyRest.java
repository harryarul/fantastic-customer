package com.util.ms.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.util.ms.model.Party;
import com.util.ms.model.request.UpdatePartyRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/parties")
@Api(value="Party", description="Operations pertaining to Party")
@PreAuthorize("hasRole(@jWTRoles.getRoles())")
public class PartyRest {
	private static final Logger LOGGER = LoggerFactory.getLogger(PartyRest.class);
	
	@ApiOperation(value = "Update party - add domain")
	@RequestMapping(value = "/party/{partyId}", method=RequestMethod.PUT,	
					consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> updatePartyDomain(@PathVariable("partyId") long  partyId, 
													@RequestBody UpdatePartyRequest updatePartyRequest, 
													HttpServletRequest request){
		LOGGER.info("update party by id "+partyId);
		
		Party party = new Party();
		return new ResponseEntity<Object>(party, HttpStatus.OK);
	}
	
}
