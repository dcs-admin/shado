package com.shado.server;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.client.RestTemplate;


 
@EnableJpaAuditing
@SpringBootApplication
@EnableOAuth2Client
@EnableScheduling
public class Application extends SpringBootServletInitializer {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
		
	}
	
	public static void main(String[] args) { 
		SpringApplication.run(Application.class, args);
	}
	
//	@Bean(initMethod = "start", destroyMethod = "stop")
//	public Server h2Server() throws SQLException {
//	    return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9093");
//	}
}
