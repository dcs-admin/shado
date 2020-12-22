package com.shado.server.config;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
 
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OAuth2ResourceServer extends ResourceServerConfigurerAdapter 
{
	private static final String ROOT_PATTERN = "/**";
	
	 
    @Override
    public void configure(HttpSecurity http) throws Exception {
    	 
    	http  
        .authorizeRequests() 
        .antMatchers("**/registration/**").permitAll()
        .and()
        .anonymous().disable();
//    	
//    	 http.authorizeRequests() 
//         
//	     .antMatchers(HttpMethod.GET, ROOT_PATTERN).access("#oauth2.hasScope('read')")
//         .antMatchers(HttpMethod.POST, ROOT_PATTERN).access("#oauth2.hasScope('write')")
//         .antMatchers(HttpMethod.PATCH, ROOT_PATTERN).access("#oauth2.hasScope('write')")
//         .antMatchers(HttpMethod.PUT, ROOT_PATTERN).access("#oauth2.hasScope('write')")
//         .antMatchers(HttpMethod.DELETE, ROOT_PATTERN).access("#oauth2.hasScope('write')")
//        //.antMatchers("/api/**").authenticated()
//        //.antMatchers("**/registration/**").permitAll()
//        //.antMatchers("**/tenant/**").permitAll() 
//        //.antMatchers("/user/**").access("hasRole('USER') or hasRole('SYSTEMADMIN') ")
//        //.antMatchers("**/hostels/**").access("hasRole('SYSTEMADMIN')") 
//        //.antMatchers("**/hostels/**").access("#oauth2.hasRole('SYSTEMADMIN')") 
//         //.antMatchers("/user/**").and().authorizeRequests().anyRequest().access("#oauth2.hasScope('USER')")
//	        //.antMatchers("/admin/**").and().authorizeRequests().anyRequest().access("#oauth2.hasScope('ADMIN')")
//         .and().exceptionHandling().accessDeniedHandler(new MyOAuth2AccessDeniedHandler());
        
          
    	 
    }
}

class MyOAuth2AccessDeniedHandler extends OAuth2AccessDeniedHandler{
	
	 
	@Override
	protected ResponseEntity<OAuth2Exception> enhanceResponse(ResponseEntity<OAuth2Exception> result,
			Exception authException) {
		 
		System.out.println(" Ram - my exception here : "+result+";"+authException);
		// TODO Auto-generated method stub
		return (ResponseEntity<OAuth2Exception>) super.enhanceResponse(result, authException);
	} 
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException)
			throws IOException, ServletException {
		 
		System.out.println("Exception Occured: "+authException.getMessage());
		super.handle(request, response, authException);
	}
}