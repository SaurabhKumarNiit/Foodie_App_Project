package com.foodieapp.customerAuthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CustomerAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerAuthenticationApplication.class, args);
	}

}
