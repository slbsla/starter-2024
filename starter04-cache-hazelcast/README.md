Spring boot : 3.0.2
Java : 17
Open API : 3  (3.0.0 , ui 2.0.2)
local URL : http://localhost:8080/swagger-ui/index.html
Run Test : OK
ALL Crud OK : Yes
Jakarta : Yes
Hibernata validator : 8.0.1

Database : h2 memory
Script default : import.sql
h2 url : http://localhost:8080/h2-console
h2 db url to set : jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
User and password : sa, null
Saved Settings:	Generic H2 (Server)


# HAZELCAST FMK
In the log should have :
Members {size:1, ver:1} [
    Member [192.168.1.41]:5701 - 72d3ad6f-4e5c-43f9-be48-680c3e35c3d8 this
]

If you want to read more, check out the official documentation https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-hazelcast[Spring Boot: Hazelcast].


Test Hazlelcast  : not working: triche