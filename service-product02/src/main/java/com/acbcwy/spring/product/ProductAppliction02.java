package com.acbcwy.spring.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductAppliction02 {
    public static void main(String[] args) {
    	SpringApplication.run(ProductAppliction02.class);
    }

}