package com.foodieapp.customerAuthentication.controller;

import com.foodieapp.customerAuthentication.domain.Customer;
import com.foodieapp.customerAuthentication.exception.CustomerNotFoundException;
import com.foodieapp.customerAuthentication.service.CustomerService;
import com.foodieapp.customerAuthentication.service.EmailService;
import com.foodieapp.customerAuthentication.service.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/customer/v1")
public class CustomerController {

    private CustomerService customerServiceImpl;

    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    private EmailService emailService;

    public CustomerController(CustomerService customerServiceImpl, SecurityTokenGenerator securityTokenGenerator) {
        this.customerServiceImpl = customerServiceImpl;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    // http://localhost:8084/customer/v1/register
    @PostMapping("/register")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer){
        Customer customer1 = customerServiceImpl.addCustomer(customer);
        boolean status = emailService.sendEmail(customer);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    // http://localhost:8084/customer/v1/login
    @PostMapping("/login")
    public ResponseEntity<?> loginCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
        ResponseEntity responseEntity = null;
        Map<String,String> map = null;
        try {
            Customer customer1 = customerServiceImpl.findByEmailAndPassword(customer.getEmail(), customer.getPassword());

            if (customer1.getEmail().equals(customer.getEmail()))
            {
                map = securityTokenGenerator.generateToken(customer);
                boolean status = emailService.sendEmailInCustomerLogin(customer);
            }
            responseEntity = new ResponseEntity<>(map,HttpStatus.OK);
        }catch (CustomerNotFoundException e) {
            throw new CustomerNotFoundException();
        }catch (Exception e){
            responseEntity = new ResponseEntity<>("Try After Some Time",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
