package com.crud.task.config;

import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;


@Configuration
public class CoreConfiguration {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
