package com.foodieapp.customerService.proxy;

import com.foodieapp.customerService.domain.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="authentication-service",url="http://authentication-service:8084")
public interface CustomerProxy {
    @PostMapping("/customer/v1/register")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer);
    
}
