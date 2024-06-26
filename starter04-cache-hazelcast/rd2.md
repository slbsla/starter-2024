:github-address: https://github.com/hazelcast-guides/springboot-caching
:templates-url: https://raw.githubusercontent.com/hazelcast-guides/adoc-templates/master
:hazelcast: Hazelcast IMDG
:framework: Spring Boot
= Caching with Spring Boot and Hazelcast

This guide will get you started to use Hazelcast as a cache manager for your Spring Boot application.

include::{templates-url}/link-to-repo.adoc[]

== What You’ll Learn

In this guide, you'll deploy a Spring Boot application which uses Hazelcast as a cache manager.

== Prerequisites

- ~5 minutes
- JDK 1.8+
- Apache Maven 3.2+

== Spring Boot Application

To use caching in your Spring Boot application, you need to:

- add `org.springframework.boot:spring-boot-starter-cache` dependency
- add `@EnableCaching` annotation to your main class
- add `@Cacheable("books")` annotation to every method you want to cache

For more explanation on the Spring Boot cache topic, please check the official Spring Guide: https://spring.io/guides/gs/caching/[Caching Data with Spring].

In our case, let's have a simple web service with two classes defined as follows.

.BookController.java
[source,java]
----
@RestController
@RequestMapping("/books")
public class BookController {
@Autowired
private BookService bookService;
@GetMapping("/{isbn}")
public String getBookNameByIsbn(@PathVariable("isbn") String isbn) {
return bookService.getBookNameByIsbn(isbn);
}
}
----

.BookService.java
[source,java]
----
@Service
public class BookService {
@Cacheable("books")
public String getBookNameByIsbn(String isbn) {
return findBookInSlowSource(isbn);
}
private String findBookInSlowSource(String isbn) {
// some long processing
try {
Thread.sleep(3000);
} catch (InterruptedException e) {
e.printStackTrace();
}
return "Sample Book Name";
}
}
----

If we started the application, then every call to the endpoint `/books/<isbn>` would go to the method `findBookNameByIsbn()` which in turn would first check the cache. Only if it does not find value in the cache, the method `findBookInSlowSource()` would be executed.

== Using Hazelcast as Cache Manager

We want to use Hazelcast as the cache manager. The good news is that all you have to do it to add Hazelcast to your classpath.

.pom.xml
----
<dependency>
    <groupId>com.hazelcast</groupId>
    <artifactId>hazelcast-all</artifactId>
    <version>4.0.2</version>
</dependency>
----

Then, you need to add Hazelcast configuration in one of the following manners:

- Add `hazelcast.yaml` configuration OR
- Add `hazelcast.xml` configuration OR
- Define `@Bean` with Hazelcast configuration in the source code

Let’s use the first option and add the following file into `src/main/resources`.

.hazelcast.yaml
[source,yaml]
----
hazelcast:
network:
join:
multicast:
enabled: true
----

No more configuration needed, Hazelcast is already used as the cache manager for your project!

== Starting the Application

To start the application, run the following command.

----
mvn spring-boot:run
----

You should see in the logs that embedded Hazelcast has started.

----
Members {size:1, ver:1} [
Member [172.30.63.9]:5701 - 75cd0b19-ee36-4e0a-9d9c-38c49f67f842 this
]
----

== Testing the Application

You can test the application by executing the following command.

----
curl locahost:8080/books/12345
Sample Book Name
----

The first time you execute this command it should take some time to get the response. However, when you try it again, it should be instant. That means that the cache is used.

----
curl locahost:8080/books/12345
Sample Book Name
----

== What's more?

Spring Boot is really well integrated with Hazelcast and vice-versa. If you want to use Hazelcast in the client-server topology, then it's enough if you create `hazelcast-client.yaml` file instead of `hazelcast.yaml` on your classpath. And that's it! You configured Hazelcast client.

If you want to read more, check out the official documentation https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-hazelcast[Spring Boot: Hazelcast].


