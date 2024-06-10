package com.example.demo;


import com.example.demo.aspect.LoggingAspect;
import com.example.demo.domain.Contact;
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.ContactService;
import com.example.demo.service.ContactServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes = {ContactService.class, LoggingAspect.class})

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {ContactService.class, LoggingAspect.class})
public class LoggingAspectTest {

    @Mock
    private JoinPoint joinPoint;

    private ContactService contactService;

    @Mock
    private ContactRepository repository;

    @InjectMocks
    private LoggingAspect loggingAspect;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        contactService = new ContactServiceImpl(repository);
        when(repository.findAll()).thenReturn(Collections.singletonList(Contact.builder().id(1L).build()));
    }


    @Test
    public void testLogAfterReturning() {
        List<Contact> res = contactService.findAll();
        ArgumentCaptor<JoinPoint> joinPointCaptor = ArgumentCaptor.forClass(JoinPoint.class);
        ArgumentCaptor<Object> resultCaptor = ArgumentCaptor.forClass(Object.class);
        loggingAspect.logAfterMethodReturn(joinPointCaptor.capture(), resultCaptor.capture());
        assertEquals("findAll", joinPointCaptor.getValue().getSignature().getName());
        assertEquals("Operation performed", resultCaptor.getValue());
    }
}
