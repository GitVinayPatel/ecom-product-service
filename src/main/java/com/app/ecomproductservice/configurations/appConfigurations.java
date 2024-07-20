package com.app.ecomproductservice.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class appConfigurations {

    @Bean
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}
