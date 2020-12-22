package com.shado.server.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class SransUser extends org.springframework.security.core.userdetails.User {
	  
	private static final long serialVersionUID = 1L;
	
	 
	
	public SransUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
 

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SransUser [subscription=");
	 
		builder.append("]");
		return builder.toString();
	}  
   
    
} 