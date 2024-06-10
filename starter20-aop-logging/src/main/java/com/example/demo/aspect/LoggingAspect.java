package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import static com.example.demo.aspect.LoggerUtils.clearMDC;
import static com.example.demo.aspect.LoggerUtils.initMDC;

@Slf4j
@Aspect
public class LoggingAspect {

    @Before("execution(* com.example.demo.controller..*(..))")
    public void logBeforeMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        initMDC();
        log.info("[INFO ] Prompt calling  method " + className + "." + methodName);
        clearMDC();

    }

    @AfterReturning(pointcut = "execution(* com.example.demo.controller.*.*(..))", returning = "result")
    public void logAfterMethodReturn(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        initMDC();
        log.info("[INFO] Exiting method with Success " + className + "." + methodName + " with result: " + result);
        clearMDC();
    }


    @AfterThrowing(pointcut = "execution(* com.example.demo.controller.*.*(..))", throwing= "ex")
    public void catchExceptionsInControllers(Exception ex) {
        initMDC();
        log.info("[ERROR] Error caught  : ", ex.getStackTrace() ) ;
        clearMDC();
    }

}