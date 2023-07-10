package com.foodieapp.customerAuthentication.service;

import com.foodieapp.customerAuthentication.domain.Customer;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String, String> generateToken(Customer customer);
}
