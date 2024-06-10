package com.example.demo;


import com.example.demo.config.AspectConfiguration;
import com.example.demo.controller.ContactController;
import com.example.demo.service.ContactService;
import com.example.demo.service.ContactServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {AspectConfiguration.class}) // Reference your existing aspect configuration
@EnableAspectJAutoProxy

public class SIX {

    private ContactController contactController; // Assume MyService is a service you want to test
    private ContactService contactService; // Assume MyService is a service you want to test

    @Test
    public void testServiceMethod() {
        contactController = new ContactController(new ContactServiceImpl(null)) ;
        contactController.findAll(); // This should trigger the aspect advice
        // Add your assertions here
    }
}


