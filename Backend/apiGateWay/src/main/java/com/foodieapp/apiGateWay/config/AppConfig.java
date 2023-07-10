package com.foodieapp.apiGateWay.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes().
                route(p->p
                        .path("/customer/v1/**")
                        .uri("http://authentication-service:8084/"))

                .route(p->p
                        .path("/customerservice/v1/**")
                        .uri("http://customer-service:8081/"))

                .route(p->p
                        .path("/admin/**")
                        .uri("http://admin-service:8085/"))

                .route(p->p
                        .path("/menu/**")
                        .uri("http://menu-service:9001/"))

                .route(p->p
                        .path("/restaurant/v1/**")
                        .uri("http://restaurant-service:9088/"))

                .route(p->p
                        .path("/api/v1/fav/**")
                        .uri("http://favorite-service:8099/"))

                .route(p->p
                        .path("/payment/**")
                        .uri("http://payment-service:8999/"))

                .route(p->p
                        .path("/cart/**")
                        .uri("http://cart-service:9003/"))
                .build();
    }
}
