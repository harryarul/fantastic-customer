package com.util.ms.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("jWTRoles")
public class JWTRoles {
	
	@Value("${roles.rolename}")
	private String roles;

	/**
	 * @return the roles
	 */
	public String getRoles() {
		return roles;
	}
	
	
}
