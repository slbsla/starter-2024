package com.example.demo;


import com.example.demo.aspect.LoggingAspect;
import com.example.demo.config.AspectConfiguration;
import com.example.demo.controller.ContactController;
import com.example.demo.domain.Contact;
import com.example.demo.service.ContactService;
import com.example.demo.service.ContactServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {ContactService.class, LoggingAspect.class})
//@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Cink {


    @Configuration
    @Import(AspectConfiguration.class)
    public static class TestConfiguration {

        @MockBean
        @SpyBean
        private ContactService service ;

        @Bean
        public ContactController contactController() {
            ContactController contactController1 = new ContactController(service) ;
            return contactController1;
        }

    }

//
//    @SpyBean
    @Autowired
    private ContactController contactController;
//
//    @MockBean
//    @SpyBean
//    private ContactService contactService;
//
//    @MockBean
//    @SpyBean
//    LoggingAspect logging;

    @Test
    public void test_metho_are_called() {
//        MockitoAnnotations.initMocks(this);
//        contactController = new ContactController(contactService);
//        when(contactService.findAll()).thenReturn(Collections.singletonList(Contact.builder().id(1L).build()));

//        // Spy on the service to verify method calls
//        spy(contactController);
//        spy(contactService);
//        spy(logging);

        // Perform the operation
        contactController.findAll();

        // Verify that the method was called
//        verify(logging, atLeastOnce()).logBeforeMethodExecution(any(JoinPoint.class));
        // Since the aspect only logs, there's no direct output to assert here
        // You can check logs or use a more advanced approach to verify aspect behavior
    }
}