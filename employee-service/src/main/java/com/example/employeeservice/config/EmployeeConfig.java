package com.example.employeeservice.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmployeeConfig {

    @Value("${addressservice.base.url}")
    private String addressBaseURL;

    @Bean
    public RestTemplate restTemplate(){

        return new RestTemplate();

    }

    @Bean
    public WebClient webClient(){


        return WebClient.builder().baseUrl(addressBaseURL).build();
    }


}
