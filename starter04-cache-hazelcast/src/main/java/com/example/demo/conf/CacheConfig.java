package com.example.demo.conf;


import com.hazelcast.client.HazelcastClient;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    @Bean
    public HazelcastInstance contactCacheInstance() {
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        instance.getConfig().addMapConfig(new MapConfig("contactCache").setTimeToLiveSeconds(30));// 30 seconds contact cach max time
        return instance;
    }

    @Bean
    public CacheManager cacheManager(HazelcastInstance hazelcastInstance) {
        return new HazelcastCacheManager(hazelcastInstance);
    }

}