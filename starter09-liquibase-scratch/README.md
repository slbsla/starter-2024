## this project provides examples of liquibase alredy configured

help : https://www.baeldung.com/liquibase-refactor-schema-of-java-app

Spring boot : 3.0.2
Java : 17
Open API : 3  (3.0.0 , ui 2.0.2)
Run Test :
Jakarta : Yes
Hibernate validator : 8.0.1
Liquibase : last versions 4.26.0 (liquibase-core)

url : http://localhost:8080/swagger-ui/index.html

TO ACTIVATE SWAGGER ONLY ADD DEPENDENCY : springdoc-openapi-starter-webmvc-ui


Database : h2 file
h2 url :http://localhost:8080/h2-console
h2 db url to set : jdbc:h2:file:./data/db (under project)
User and password : sa, null
Saved Settings:	Generic H2 (Server)

Set spring.jpa.hibernate.ddl-auto=create for first time

### conf h2 file

spring.jpa.hibernate.ddl-auto=create
spring.datasource.url=jdbc:h2:file:./data/db;DB_CLOSE_DELAY=-1
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.datasource.platform=h2
spring.datasource.initialize=true
spring.datasource.continue-on-error=true


## db mysql 
## workbench (8.0) + server installer 8.0.x
## db name : db_demo

## PASSWORD/User : root admin

## driver : mysql-connector-java : 8.0.29
