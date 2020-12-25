package com.mcare.server.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	 

	@GetMapping("/whoami")
    @PreAuthorize("permitAll()")
    public Object user(Authentication principal) {
        return principal.getPrincipal();
    }
   
     
    
}
