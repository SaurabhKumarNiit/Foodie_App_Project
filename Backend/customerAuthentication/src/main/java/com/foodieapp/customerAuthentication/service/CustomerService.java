package com.foodieapp.customerAuthentication.service;

import com.foodieapp.customerAuthentication.domain.Customer;
import com.foodieapp.customerAuthentication.exception.CustomerNotFoundException;

public interface CustomerService {
    public Customer addCustomer(Customer customer);

    public Customer findByEmailAndPassword(String email,String password) throws CustomerNotFoundException;

}
