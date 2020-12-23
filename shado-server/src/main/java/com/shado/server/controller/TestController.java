package com.shado.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shado.server.model.User;
import com.shado.server.oauth2service.UserService;

@RestController
public class TestController {
	
	@Autowired
	private UserService userService;  

	@GetMapping("/whoami")
    @PreAuthorize("permitAll()")
    public Object user(Authentication principal) {
        return principal.getPrincipal();
    }
   
    
    @GetMapping("/v1/users")
    @PreAuthorize("authentication.principal == 'admin'")
    public ResponseEntity<List<User>> getUsers() {
    	
    	List<User> users = userService.getAll(); 
    	return new ResponseEntity<List<User>>(users, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping("/v1/users/{id}")
    //@PreAuthorize("@securityCheck.check(#id,authentication)")
    @PreAuthorize("authentication.principal == 'admin' AND #id == 12 ")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
    	
    	User usernew = userService.get(id); 
    	return new ResponseEntity<User>(usernew, new HttpHeaders(), HttpStatus.OK);
    }
    
    @DeleteMapping("/v1/users/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id) {
    	
    	userService.delete(id); 
    	boolean isDone = true;
    	return new ResponseEntity<Boolean>(isDone, new HttpHeaders(), HttpStatus.OK);
    }
    
}