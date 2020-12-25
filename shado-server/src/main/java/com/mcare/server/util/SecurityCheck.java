package com.mcare.server.util;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

 

@Component
public class SecurityCheck {


	public boolean check(Long id, Authentication authentication) {
		System.out.println("ID: "+id);
		System.out.println("getName: "+authentication.getName());
	    System.out.println("getPrincipal: "+authentication.getPrincipal());
	    System.out.println("getAuthorities: "+authentication.getAuthorities());
		    
	    if(id == null)
	        return false;
	    
	    if(Long.parseUnsignedLong(authentication.getPrincipal()+"") == id) {
	    	 System.out.println("matched:");
	    	return true;
	    }
	   
	   // more logic ... 
	   return false;
	 }
}