package com.util.ms.security;

import java.sql.Timestamp;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUser implements UserDetails {

    private final String username;
    private final Collection<? extends GrantedAuthority> authorities;
    private Timestamp requestDate;

	public JwtUser(
          String username,
          Collection<? extends GrantedAuthority> authorities,
          Timestamp requestDate
    ) {
        this.username = username;
        this.authorities = authorities;
        this.requestDate = requestDate;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @JsonIgnore
    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    

    /**
	 * @return the requestDate
	 */
	public Timestamp getRequestDate() {
		return requestDate;
	}

	/**
	 * @param requestDate the requestDate to set
	 */

	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}
}

