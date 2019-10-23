package com.util.ms.security;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
	private final Log LOGGER = LogFactory.getLog(this.getClass());
	@Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        String username  = jwtTokenUtil.getUsername(token);
        if(StringUtils.isEmpty(username)) {
        	 throw new UsernameNotFoundException(String.format("No user found with token"));
        }else {
        	String authorityString = jwtTokenUtil.getRoles(token);
        	LOGGER.info("roles are "+authorityString);
        	List<GrantedAuthority> authorityList=AuthorityUtils.commaSeparatedStringToAuthorityList(authorityString);
        	if(!CollectionUtils.isEmpty(authorityList)) {
        		authorityList.forEach(authority->LOGGER.info("authority is "+authority.toString()));
        	}
        	return new JwtUser(username,authorityList, new Timestamp(Calendar.getInstance().getTimeInMillis()));
        }
    }
}

