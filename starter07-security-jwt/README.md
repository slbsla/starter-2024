Tuto JWT  : https://dev.to/pryhmez/implementing-spring-security-6-with-spring-boot-3-a-guide-to-oauth-and-jwt-with-nimbus-for-authentication-2lhf
git : https://github.com/pryhmez/springsecuritytutorial
Spring boot : 3.0.2
Java : 17
Open API : 3  (3.0.0 , ui 2.0.2)
local URL : http://localhost:8080/swagger-ui/index.html
Jakarta : Yes
db  : h2
console h2 : http://localhost:8080/h2-console
security : oui
Technology : oAuth23

decoder : Nimbus + BCryptPasswordEncoder
using java 17  record : yes


#####################################
Summery :

A quick explanation of all the components of our setup and the authentication flow

* We set up our project using springdataJPA, OAuth2 Resource Server, postgres driver, and spring web.
* We created our user package, auth package, and config package.
* We created public-keys and private-keys using OpenSSL for encrypting and decrypting JWTs and linked it to our application through the applicationConfig.yaml and setting up properties.
* we created a user entity and a user repository for making JPA database calls.
* we created an auth user that would manage roles, credentials, etc.
* we created a JpaUserDetailsService for managing user details at sign-in, authService for managing auth logic like generating tokens.
* We created a DTO to help us manage data transfers between the client and server request and response.
* We used created an authController to manage routes for authentication requests like login.
* Then we setup our Security configurations to used Nimbus to manage JWTs and also user our UserDetailsService to manage user details on signin.