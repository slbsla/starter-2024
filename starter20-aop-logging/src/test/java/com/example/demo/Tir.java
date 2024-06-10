package com.example.demo;

import com.example.demo.aspect.LoggingAspect;
import com.example.demo.controller.ContactController;
import com.example.demo.domain.Contact;
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.ContactService;
import com.example.demo.service.ContactServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {ContactService.class, LoggingAspect.class})
class Tir {

    @Autowired
    LoggingAspect logging;

    @Mock
    private JoinPoint joinPoint;

    private ContactController contactController;

    @Mock
    private ContactService contactService;


//    @InjectMocks
//@Autowired
    @Mock
    private LoggingAspect loggingAspect;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        contactController = new ContactController(contactService);
        when(contactService.findAll()).thenReturn(Collections.singletonList(Contact.builder().id(1L).build()));
    }

    @Test
    public void testBeforeOtherControllerCall() throws Throwable {
        ///JoinPoint joinPoint = mock(JoinPoint.class);

        //LoggingAspect logging = new LoggingAspect();
        //Signature signature = mock(Signature.class);

       //when(joinPoint.getSignature()).thenReturn(signature);
        //when(signature.getName()).thenReturn("MethodName");

        //String[] args = { "arg1", "arg2" };

        Object object = mock(Object.class);
        when(joinPoint.getTarget()).thenReturn(object);
        //when(joinPoint.getArgs()).thenReturn(args);

        contactController.findAll();
        verify(loggingAspect, times(1)).logBeforeMethodExecution(any(JoinPoint.class));

        //logging.logBeforeMethodExecution(joinPoint);

//        verify(joinPoint, times(1)).getSignature();
//        verify(signature, times(1)).getName();
//        verify(joinPoint, times(1)).getTarget();

    }
}
