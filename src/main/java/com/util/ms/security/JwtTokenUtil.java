package com.util.ms.security;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JwtTokenUtil {
	 private final Log LOGGER = LogFactory.getLog(this.getClass());
	 private final static boolean isGerUserName = true;
	 private final static boolean isGetRoles = false;
	
	
	public String getUsername(String token) {
		
		return decode(token,isGerUserName);
	}
	
	public String getRoles(String token){
		
		return decode(token,isGetRoles);
	}
	
	//should be deprecate after get proper signed key
	private String decode(String signedJWTToken,boolean isGetName) {
		String[] split_string = signedJWTToken.split("\\.");
		String base64EncodedHeader = split_string[0];
		String base64EncodedBody = split_string[1];

		String decodedHeader = new String(Base64Utils.decodeFromString(base64EncodedHeader));
		LOGGER.info("Decoded Header :");
		LOGGER.info("===========================");
		LOGGER.info(decodedHeader);

		LOGGER.info("Decoded Body :");
		LOGGER.info("============================");
		String decodedBody = new String(Base64Utils.decodeFromString(base64EncodedBody));
		LOGGER.info(decodedBody);
		
		if(isGetName) {
			try {
				JsonNode rootNode = new ObjectMapper().readTree(new StringReader(decodedBody));
				JsonNode subs = rootNode.get("http://wso2.org/claims/subscriber");
				if(subs != null) {
					return subs.asText();
				}
			} catch (JsonParseException e) {
				LOGGER.error("Unable to decode JWT Token", e);
			} catch (JsonMappingException e) {
				LOGGER.error("Unable to decode JWT Token", e);
			} catch (IOException e) {
				LOGGER.error("Unable to decode JWT Token", e);
			}
		}else {
			try {
				JsonNode rootNode = new ObjectMapper().readTree(new StringReader(decodedBody));
				JsonNode subs = rootNode.get("http://wso2.org/claims/role");
				if(subs != null&&subs.isArray()) {
					String roles = StreamSupport.stream(subs.spliterator(), true)
					.map(s->"ROLE_"+s.asText().toUpperCase())
					.collect(Collectors.joining(","));
					LOGGER.info("Roles from token "+roles);
					return roles;
				}
			} catch (JsonParseException e) {
				LOGGER.error("Unable to decode JWT Token", e);
			} catch (JsonMappingException e) {
				LOGGER.error("Unable to decode JWT Token", e);
			} catch (IOException e) {
				LOGGER.error("Unable to decode JWT Token", e);
			}
		}
		
		return null;
	} 
	
/*	public static void main(String[] args) {
		String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6ImFfamhOdXMyMUtWdW9GeDY1TG1rVzJPX2wxMCJ9.eyJodHRwOlwvXC93c28yLm9yZ1wvY2xhaW1zXC9yb2xlIjpbIkludGVybmFsXC9zdWJzY3JpYmVyIiwiSW50ZXJuYWxcL2NyZWF0b3IiLCJJbnRlcm5hbFwvcHVibGlzaGVyIiwiSW50ZXJuYWxcL2V2ZXJ5b25lIiwiYWRtaW4iLCJBcHBsaWNhdGlvblwvYWRtaW5fQk0tT2N0YW5lX1NBTkRCT1giXSwiaHR0cDpcL1wvd3NvMi5vcmdcL2NsYWltc1wvYXBwbGljYXRpb250aWVyIjoiVW5saW1pdGVkIiwiaHR0cDpcL1wvd3NvMi5vcmdcL2NsYWltc1wva2V5dHlwZSI6IlNBTkRCT1giLCJodHRwOlwvXC93c28yLm9yZ1wvY2xhaW1zXC92ZXJzaW9uIjoiMS4wIiwiaXNzIjoid3NvMi5vcmdcL3Byb2R1Y3RzXC9hbSIsImh0dHA6XC9cL3dzbzIub3JnXC9jbGFpbXNcL2FwcGxpY2F0aW9ubmFtZSI6IkJNLU9jdGFuZSIsImh0dHA6XC9cL3dzbzIub3JnXC9jbGFpbXNcL2VuZHVzZXIiOiJhZG1pbkBjYXJib24uc3VwZXIiLCJodHRwOlwvXC93c28yLm9yZ1wvY2xhaW1zXC9lbmR1c2VyVGVuYW50SWQiOiItMTIzNCIsImh0dHA6XC9cL3dzbzIub3JnXC9jbGFpbXNcL3N1YnNjcmliZXIiOiJhZG1pbiIsImh0dHA6XC9cL3dzbzIub3JnXC9jbGFpbXNcL3RpZXIiOiJVbmxpbWl0ZWQiLCJodHRwOlwvXC93c28yLm9yZ1wvY2xhaW1zXC9hcHBsaWNhdGlvbmlkIjoiMTAiLCJodHRwOlwvXC93c28yLm9yZ1wvY2xhaW1zXC91c2VydHlwZSI6IkFQUExJQ0FUSU9OIiwiZXhwIjoxNTA2NDA2ODM0LCJodHRwOlwvXC93c28yLm9yZ1wvY2xhaW1zXC9hcGljb250ZXh0IjoiXC9oZWFkZXJzXC8xLjAifQ==.DPsir24/H/u+0UdG04+b4mDC9LHYg8L7aDa6tjeZVVtv98nwRJK92rl5Rhqo+SabGOPEc1CvBPU7NCIvx9kQs7zispT0pqFJ8usTKeUwNFvw+zJK2EnIaq/zDl+AWGxtAiSb7wwQeZ+tmTULUYeIhFOU2ExR5+JsC5QXyPLEhtM=";
		JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
		jwtTokenUtil.decode(token,false);
	}*/
}
