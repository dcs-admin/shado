package com.shado.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shado.server.model.User;
import com.shado.server.model.UserSubscription;
import com.shado.server.oauth2service.SubscriptionService;
import com.shado.server.oauth2service.UserService;
import com.shado.server.util.SecurityCheck;

@RestController
public class UserSubscriptionController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@Autowired
	private SecurityCheck securityCheck;
	

    @GetMapping("/user/me")
    @PreAuthorize("permitAll()")
    public AuthenticationPrincipal user(AuthenticationPrincipal principal) {
        return principal;
    }
    
    @PostMapping("/v1/users")
    public ResponseEntity<UserSubscription> addUserWithSubscription(@RequestBody UserSubscription userSubscription) {
    	
    	UserSubscription userSubscriptionNew =  new UserSubscription();
    	//userSubscriptionNew.setUser(userService.save(userSubscription.getUser()));
    	//userSubscriptionNew.setSubscription(subscriptionService.save(userSubscription.getSubscription()));
    	
    	return new ResponseEntity<UserSubscription>(userSubscriptionNew, new HttpHeaders(), HttpStatus.OK);
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
