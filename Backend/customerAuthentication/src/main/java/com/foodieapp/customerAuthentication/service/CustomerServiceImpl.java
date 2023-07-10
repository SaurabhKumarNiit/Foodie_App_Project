package com.foodieapp.customerAuthentication.service;

import com.foodieapp.customerAuthentication.domain.Customer;
import com.foodieapp.customerAuthentication.exception.CustomerNotFoundException;
import com.foodieapp.customerAuthentication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl( CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findByEmailAndPassword(String email, String password) throws CustomerNotFoundException {
        Customer admin = customerRepository.findByEmailAndPassword(email, password);
        if (admin == null){
            throw new CustomerNotFoundException();
        }
        return admin;
    }
}
