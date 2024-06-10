package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.demo..*.*(..))")
    public void logBeforeMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        System.out.println("[INFO ] Before Entering method " + className + "." + methodName);
    }

    @AfterReturning(pointcut = "execution(* com.example.demo.*.*(..))", returning = "result")
    public void logAfterMethodExecution(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        log.info("[INFO] Exiting method " + className + "." + methodName + " with result: " + result);
    }
}