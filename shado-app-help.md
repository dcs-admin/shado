 
 
 -- Queries

create table user (id int8 not null, age int4, password varchar(255), role varchar(255), salary int8, username varchar(255), primary key (id));
 
create table subscription (id int4 not null, comments varchar(255), created_date timestamp, type varchar(255), updated_date timestamp, user_name varchar(255), valid_from timestamp, valid_to timestamp, primary key (id));


insert into user(ID,AGE,PASSWORD,ROLE,SALARY,USERNAME ) values (10,1,'$2a$10$I7TXz9O29lrNiwW2HCCyOuuBpXy0M3IhPEmVQngnf6bJkWrggHTIa','ADMIN',1,'admin');
insert into user(ID,AGE,PASSWORD,ROLE,SALARY,USERNAME ) values (11,1,'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu','USER',1,'user');
insert into user(ID,AGE,PASSWORD,ROLE,SALARY,USERNAME ) values (12,1,'$2a$10$I7TXz9O29lrNiwW2HCCyOuuBpXy0M3IhPEmVQngnf6bJkWrggHTIa','SYSTEMADMIN',1,'superadmin');
insert into user(ID,AGE,PASSWORD,ROLE,SALARY,USERNAME ) values (13,1,'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu','ALL',1,'anji');




--- Server Startup Help[OAuth2 Authorization and Authentication]

# UAA
cd E:\findme\shado-uaa
mvn package && java -jar target\shado-uaa-1.0.0.jar  

H2: 
http://localhost:9090/uaa-server/h2_console/  
jdbc:h2:file:~/h2/shado-db;AUTO_SERVER=TRUE 

# Server
cd E:\findme\shado-server
mvn package && java -jar target\shado-server-1.0.0.jar

H2:
http://localhost:9900/shado-server/h2_console
jdbc:h2:file:~/h2/shado-db;AUTO_SERVER=TRUE 


--- Client APP
cd E:\findme\findme-app
ionic serve




