package com.srans.uaa;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/**
 * 
 * @author ram
 * 
 * insert into user(ID,AGE,PASSWORD,ROLE,SALARY,USERNAME ) values (10,1,'$2a$10$I7TXz9O29lrNiwW2HCCyOuuBpXy0M3IhPEmVQngnf6bJkWrggHTIa','SYSTEMADMIN',1,'admin');
 * insert into user(ID,AGE,PASSWORD,ROLE,SALARY,USERNAME ) values (11,1,'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu','USER',1,'user')
 *
 */
@SpringBootApplication
//@EnableResourceServer
public class UAAServerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(UAAServerApplication.class, args);
    }
    
//    @Bean(initMethod = "start", destroyMethod = "stop")
//    public Server h2Server() throws SQLException {
//        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
//    }
   
}
