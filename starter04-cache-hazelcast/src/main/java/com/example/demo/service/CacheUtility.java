package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CacheUtility {
    @CacheEvict(value = "contactCache", allEntries = true)
    public void invalidateCache() {
        log.info("cache is been cleaned");
    }
}
