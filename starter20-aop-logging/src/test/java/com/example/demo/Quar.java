package com.example.demo;

import com.example.demo.aspect.LoggingAspect;
import com.example.demo.service.ContactService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {ContactService.class, LoggingAspect.class})
public class Quar {


    @Mock
    private LoggingAspect loggingAspect;

    @Test
    void testLogBefore() {
        // Given
        LoggingAspect loggingAspect = new LoggingAspect();

        // Creating mock objects
        JoinPoint joinPoint = mock(JoinPoint.class);
        Signature signature = mock(Signature.class);

        // Configuring mock behavior
        when(joinPoint.getSignature()).thenReturn(signature);
        when(joinPoint.getTarget()).thenReturn(new Object());

        when(signature.getName()).thenReturn("methodName");

        // When
        loggingAspect.logBeforeMethodExecution(joinPoint);

        // Then
        verify(joinPoint, times(1)).getSignature();
        verify(signature, times(1)).getName();

    }
}
