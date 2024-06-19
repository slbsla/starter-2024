package com.example.demo.conf;


import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    @Bean
    public HazelcastInstance contactCacheInstance() {
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        instance.getConfig().addMapConfig(new MapConfig("contactCache").setTimeToLiveSeconds(30));// 30 seconds contact cach max time
        instance.getConfig().addMapConfig(new MapConfig("serviceCache").setTimeToLiveSeconds(10));// 30 seconds contact cach max time
        return instance;
    }

    @Bean
    public HazelcastInstance serviceCacheInstance() {
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        return instance;
    }

}