package ru.mirea.service2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.net.URI;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DiscoveryClientControllerTest {
    DiscoveryClientController sut;

    @Mock
    DiscoveryClient discoveryClient;

    @BeforeEach
    void setUp() {
        sut = new DiscoveryClientController(discoveryClient);
    }

    @Test
    void testServiceUrl() {
        var serviceInstance = new ServiceInstance() {
            @Override
            public String getServiceId() {
                return null;
            }

            @Override
            public String getHost() {
                return null;
            }

            @Override
            public int getPort() {
                return 0;
            }

            @Override
            public boolean isSecure() {
                return false;
            }

            @Override
            public URI getUri() {
                return URI.create("hello:1234");
            }

            @Override
            public Map<String, String> getMetadata() {
                return null;
            }
        };

        when(discoveryClient.getInstances("service")).thenReturn(List.of(serviceInstance));

        var result = sut.serviceUrl("service").get();
        assertEquals(serviceInstance.getUri(), result);
    }
}
