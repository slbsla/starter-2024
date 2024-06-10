package com.example.demo.config;

import com.example.demo.aspect.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfiguration {
    @Bean
    LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }
}
