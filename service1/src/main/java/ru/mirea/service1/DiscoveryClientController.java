package ru.mirea.service1;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.naming.ServiceUnavailableException;
import java.net.URI;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class DiscoveryClientController {
    private final DiscoveryClient discoveryClient;

    @Value("${spring.application.name}")
    private String applicationName;

    public Optional<URI> serviceUrl(String serviceName) {
        return discoveryClient.getInstances(serviceName)
          .stream()
          .findFirst() 
          .map(ServiceInstance::getUri);
    }

    @GetMapping("/discoveryClient/{serviceName}")
    public String discoveryPing(@PathVariable String serviceName) throws RestClientException,
            ServiceUnavailableException {
        URI service = serviceUrl(serviceName)
                .map(s -> s.resolve("/hello"))
                .orElseThrow(ServiceUnavailableException::new);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(service, String.class);
    }

    @GetMapping("/hello")
    public String ping() {
        return "Hello from " + applicationName + ")";
    }

    @GetMapping("/health-check")
    public ResponseEntity<String> myCustomCheck() {
        String message = "Im good";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}