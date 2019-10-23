/**
 * 
 */
package com.util.ms.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.util.ms.model.ErrorMessage;
import com.util.ms.model.request.PartyTypesEnum;

/**
 * @author Kath
 *
 */
@Component
public class PartyRequestValidator {

	private static final Logger LOGGER = LoggerFactory.getLogger(PartyRequestValidator.class);

	/**
	 * Check if a party type on the request is valid
	 * 
	 * @param type
	 * @return
	 */
	public ErrorMessage validatePartyTypeValue(String type) {
		ErrorMessage errorMessage = null;
		try {
			if(!PartyTypesEnum.contains(type)){
				errorMessage = new ErrorMessage(type + " is not a valid value for partyType");
			}
		}catch(Exception e) {
			LOGGER.error("Error occurred while validating party type: " + e.getMessage());
		}
		
		return errorMessage;
	}
	
}
