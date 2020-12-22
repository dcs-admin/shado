package com.shado.server.util;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

 

@Component
public class SecurityCheck {


public boolean check(Long id, Authentication authentication) {
	System.out.println("ID: "+id);
    if(id == null)
        return false;
    
    System.out.println("getName: "+authentication.getName());
    System.out.println("getPrincipal: "+authentication.getPrincipal());
    System.out.println("getAuthorities: "+authentication.getAuthorities());
   // more logic ... 
   return true;
 }
}