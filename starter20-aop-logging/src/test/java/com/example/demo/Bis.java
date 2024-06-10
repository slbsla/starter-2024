package com.example.demo;

import com.example.demo.aspect.LoggingAspect;
import com.example.demo.service.ContactService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {ContactService.class, LoggingAspect.class})

public class Bis {

    @Autowired
    LoggingAspect logging;

    @Test
    public void testBeforeOtherControllerCall() throws Throwable {
        JoinPoint joinPoint = mock(JoinPoint.class);
        //LoggingAspect logging = new LoggingAspect();
        Signature signature = mock(Signature.class);

        when(joinPoint.getSignature()).thenReturn(signature);
        when(signature.getName()).thenReturn("MethodName");

        String[] args = { "arg1", "arg2" };

        Object object = mock(Object.class);
        when(joinPoint.getTarget()).thenReturn(object);
        when(joinPoint.getArgs()).thenReturn(args);

        logging.logBeforeMethodExecution(joinPoint);

        verify(joinPoint, times(1)).getSignature();
        verify(signature, times(1)).getName();
        verify(joinPoint, times(1)).getTarget();

    }
}
