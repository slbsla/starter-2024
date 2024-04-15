package com.slb.dev;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

  //  @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private HazelcastInstance hazelcastInstance;

    //@Test
    public void useCachedValue() {
        // given
        String isbn = "12345";
        String cachedValue = "cached-value";
        hazelcastInstance.getMap("books").put(isbn, cachedValue);

        // when
        String response = restTemplate.getForObject(String.format("http://localhost:%s/books/%s", port, isbn), String.class);

        // then
        assertThat(response).isEqualTo(cachedValue);
    }
}