package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.demo.conf.CacheConfig;
import com.example.demo.controller.DTOCache;
import com.example.demo.domain.Contact;
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.CacheUtility;
import com.example.demo.service.ContactServiceImpl;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

import java.util.Collections;

@EnableCaching
@SpringBootTest
@Import(CacheConfig.class)
class CacheTest {

    @InjectMocks
    private CacheUtility cacheUtility ;
    @Mock
    private HazelcastInstance hazelcastInstance;
    @Mock
    private CacheManager cacheManager;
    @Mock
    private Cache cache;
    @InjectMocks
    private ContactServiceImpl contactService;
    @Mock
    private ContactRepository contactRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(cacheManager.getCache("contactCache")).thenReturn(cache);
        contactService = new ContactServiceImpl(contactRepository);
        when(contactRepository.findAll()).thenReturn(Collections.singletonList(Contact.builder().id(1L).email("any").build()));
    }

    @Test
    void test_hazelcast_config() {
        assertNotNull(hazelcastInstance, "HazelcastInstance should not be null");
        assertNotNull(cacheManager, "cacheManager is not null");
        assertNotNull(cacheManager.getCache("contactCache"), "is not empty");
    }

    @Test
    void test_cache_map() throws InterruptedException {

        String key = "testKey";

        DTOCache expected = DTOCache.builder()
                .contactList(Collections.singletonList(Contact.builder().id(1L).email("any").build()))
                .token(key)
                .build();

        IMap<Object, Object> map = mock(IMap.class);
        when(hazelcastInstance.getMap("contactCache")).thenReturn(map);
        when(cache.get(key)).thenReturn(() -> expected);

        DTOCache r1 = contactService.findAllCached(key);

        DTOCache r2 = contactService.findAllCached(key);

        // Verify the results
        assertNotNull(cache.get(key));
        assertNotNull(cache.get(key));
        assertEquals(expected, r1);
        assertEquals(expected, r2);
    }

    @Test
    public void test_cache_is_clear_when_invalidate() throws InterruptedException {
        String key = "testKey";
        IMap<Object, Object> map = mock(IMap.class);
        when(hazelcastInstance.getMap("contactCache")).thenReturn(map);
        DTOCache r1 = contactService.findAllCached(key);
        // Evict cache
        cacheUtility.invalidateCache();
        // Verify cache eviction
        assertNull(cache.get(key));
    }

}
