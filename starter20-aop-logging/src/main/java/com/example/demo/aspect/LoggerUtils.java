package com.example.demo.aspect;

import lombok.experimental.UtilityClass;
import org.slf4j.MDC;

import java.util.UUID;

@UtilityClass
public class LoggerUtils {

    public static void clearMDC() {
        MDC.clear();
    }
    public static void initMDC() {
        MDC.put("transaction.id", UUID.randomUUID().toString());
        MDC.put("user.id", "samir");
    }
}
