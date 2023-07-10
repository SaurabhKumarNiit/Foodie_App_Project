package com.foodieapp.menuService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MenuServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuServiceApplication.class, args);
	}

}
