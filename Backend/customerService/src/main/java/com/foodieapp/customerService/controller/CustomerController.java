package com.foodieapp.customerService.controller;

import com.foodieapp.customerService.domain.Cart;
import com.foodieapp.customerService.domain.Customer;
import com.foodieapp.customerService.domain.Favourite;
import com.foodieapp.customerService.exception.CustomerAlreadyExitsException;
import com.foodieapp.customerService.exception.CustomerNotFoundException;
import com.foodieapp.customerService.exception.FavouriteAlreadyExistException;
import com.foodieapp.customerService.exception.ItemAlreadyExists;
import com.foodieapp.customerService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/customerservice/v1")
public class CustomerController {
    private  ResponseEntity responseEntity;
    private CustomerService customerService;



    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

//    http://localhost:8081/customerservice/v1/register
    @PostMapping("/register")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) throws CustomerAlreadyExitsException {
        Customer customer1 = null;
        try {
            customer1 = customerService.registerCustomer(customer);
        } catch (CustomerAlreadyExitsException e) {
            throw new CustomerAlreadyExitsException();
        }
        return responseEntity=new ResponseEntity<>(customer1, HttpStatus.CREATED);
    }

    //http://localhost:8081/customerservice/v1/customers/{email}
    @GetMapping("/customers/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email){
        try {
            responseEntity = new ResponseEntity<>(customerService.getCustomerByEmail(email),HttpStatus.OK);
        }catch (CustomerNotFoundException e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    //http://localhost:8081/customerservice/v1/customers/address/{email}
    @GetMapping("/customers/address/{email}")
    public ResponseEntity<?> getUserAddressByEmail(@PathVariable String email){
        try {
            responseEntity = new ResponseEntity<>(customerService.getAddressByEmail(email),HttpStatus.OK);
        }catch (CustomerNotFoundException e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    //  http://localhost:8081/customerservice/v1/customers
    @GetMapping("/customers")
    public ResponseEntity<?> getAllUser(){
        try {
            responseEntity = new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
        }catch (CustomerNotFoundException e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    //http://localhost:8081/customerservice/v1/customers/update/{email}

    @PutMapping("customers/update/{email}")
    public ResponseEntity<?> updateUser(@RequestBody Customer customer, @PathVariable String email){
            return new ResponseEntity<>(customerService.updateCustomerDetails(customer,email),HttpStatus.CREATED);
    }

    //   http://localhost:8081/customerservice/v1/customer/addToCart/{email}
    @PutMapping("/customer/addToCart/{email}")
    public ResponseEntity<?> addItemsForCustomer(@PathVariable("email") String email, @RequestBody Cart cart) throws ItemAlreadyExists  {
        try{
            Customer track=customerService.addItemInCart(email,cart);
            responseEntity=new ResponseEntity<>(track,HttpStatus.OK);

        }  catch (ItemAlreadyExists e) {

            throw new ItemAlreadyExists();
        }

        return responseEntity;
    }


    //   http://localhost:8081/customerservice/v1/customer/addToFavourite/{email}
    @PutMapping("/customer/addToFavourite/{email}")
    public ResponseEntity<?> addFavouriteForCustomer(@PathVariable("email") String email, @RequestBody Favourite favourite) throws FavouriteAlreadyExistException{
        try{
            Customer track=customerService.addFavourite(email,favourite);
//            List<Favourite> favourites = customerService.addFavourite(email, favourite);
            responseEntity=new ResponseEntity<>(track,HttpStatus.OK);

        }  catch (FavouriteAlreadyExistException e) {

            throw new FavouriteAlreadyExistException();
        }

        return responseEntity;
    }

    //   http://localhost:8081/customerservice/v1/customer/cartItems/{email}
    @GetMapping("/customer/cartItems/{email}")
    public ResponseEntity<?> getCartItems(@PathVariable String email){

            responseEntity = new ResponseEntity<>(customerService.getCartItemByCustomerEmail(email), HttpStatus.OK);

        return responseEntity;
    }


    //   http://localhost:8081/customerservice/v1/customer/favourites/{email}
    @GetMapping("/customer/favourites/{email}")
    public ResponseEntity<?> getFavourites(@PathVariable String email){

        responseEntity = new ResponseEntity<>(customerService.getFavouriteByCustomerEmail(email), HttpStatus.OK);

        return responseEntity;
    }


    //   http://localhost:8081/customerservice/v1/delete/{email}/{itemId}
    @DeleteMapping("/delete/{email}/{itemId}")
    public ResponseEntity<?> deleteCartItem(@PathVariable(value = "email")String email,@PathVariable(value = "itemId") String itemId) throws Exception {
        return new ResponseEntity<>(customerService.deleteCartItem(email,itemId),HttpStatus.OK);

    }


    //   http://localhost:8081/customerservice/v1/delete/favourite/{email}/{itemId}
    @DeleteMapping("/delete/favourite/{email}/{itemId}")
    public ResponseEntity<?> deleteFavourite(@PathVariable(value = "email")String email,@PathVariable(value = "itemId") String itemId) throws Exception {
        return new ResponseEntity<>(customerService.deleteFavourite(email,itemId),HttpStatus.OK);
    }

    //  http://localhost:8081/customerservice/v1/deleteAll/{email}
    @DeleteMapping("/deleteAll/{email}")
    public ResponseEntity<?> deleteAllCart(@PathVariable String email){
        return new ResponseEntity<>(customerService.deleteAllCustomerItems(email),HttpStatus.OK);
    }


    //   http://localhost:8081/customerservice/v1/customer/updateQuantity/{email}/{quantity}
    @PutMapping("/customer/updateQuantity/{email}/{quantity}")
    public ResponseEntity<?> updateQuantity(@PathVariable("email") String email, @RequestBody Cart cart,@PathVariable("quantity") int quantity ){

        Customer updateQuantity = customerService.updateQuantity(email, cart, quantity);

        return new ResponseEntity<>(updateQuantity,HttpStatus.OK);
    }



}
