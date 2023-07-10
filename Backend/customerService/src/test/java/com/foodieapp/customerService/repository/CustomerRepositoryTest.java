//package com.foodieapp.customerService.repository;
//
//
//import com.foodieapp.customerService.domain.Address;
//import com.foodieapp.customerService.domain.Customer;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class CustomerRepositoryTest {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    private Address address;
//
//    private Customer customer;
//
//    @BeforeEach
//    public void setUp(){
//        address = new Address("663","girnar3","Indore3","245784");
//        customer = new Customer("Megha3","megha125@gmail.com","megha@134","1457896523", address);
//    }
//
//    @AfterEach
//    public void tearDown(){
//        address = null;
//        customer = null;
//        customerRepository = null;
//    }
//
//    @Test
//    @DisplayName("Test case for saving customer object")
//    public void saveCustomerTest(){
//        customerRepository.save(customer);
//        Customer customer1 = customerRepository.findById(customer.getEmail()).get();
//        assertNotNull(customer1);
//        assertEquals(customer.getEmail(),customer1.getEmail());
//
//    }
//
//    @Test
//    @DisplayName("Test case for retreiving all customer object")
//    public void fetchCustomerTest(){
//        customerRepository.insert(customer);
//        List<Customer> list = customerRepository.findAll();
//        assertEquals(4,list.size());
//        assertEquals("megha125@gmail.com",list.get(3).getEmail());
//    }
//}
