package com.example.employeeservice.feignclient;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;


@LoadBalancerClient(value="address-app",configuration =MyCustomLoadConfiguration.class )
public class AddressServiceLoadBalancer {

    @LoadBalanced
    @Bean
    public Feign.Builder feignBuilder(){

        return Feign.builder();
    }
}
