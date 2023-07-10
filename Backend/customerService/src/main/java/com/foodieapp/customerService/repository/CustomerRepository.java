package com.foodieapp.customerService.repository;

import com.foodieapp.customerService.domain.Address;
import com.foodieapp.customerService.domain.Cart;
import com.foodieapp.customerService.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {

    public Customer findByEmailAndPassword(String email, String password);
    Customer findByEmail(String email);

//    @Query("{'cart' : {$in : [?0]}}")
//
//    Cart findCartByEmail(String email);

}
