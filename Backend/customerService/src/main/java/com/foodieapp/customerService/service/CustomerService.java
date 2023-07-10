package com.foodieapp.customerService.service;

import com.foodieapp.customerService.domain.Address;
import com.foodieapp.customerService.domain.Cart;
import com.foodieapp.customerService.domain.Customer;
import com.foodieapp.customerService.domain.Favourite;
import com.foodieapp.customerService.exception.CustomerAlreadyExitsException;
import com.foodieapp.customerService.exception.CustomerNotFoundException;
import com.foodieapp.customerService.exception.FavouriteAlreadyExistException;
import com.foodieapp.customerService.exception.ItemAlreadyExists;

import java.util.List;

public interface CustomerService {
    public Customer registerCustomer(Customer customer) throws CustomerAlreadyExitsException;
    //Customer addAddressForCustomer(String email, Address address) ;
    public List<Customer> getAllCustomers() throws CustomerNotFoundException;

    public Customer getCustomerByEmail(String email) throws CustomerNotFoundException;
    public Customer updateCustomerDetails(Customer customer, String email);
    public Address getAddressByEmail(String email) throws CustomerNotFoundException;
    Customer addItemInCart(String email, Cart cart) throws ItemAlreadyExists;

    Customer updateQuantity(String email, Cart cart,int quantity);

    Customer addFavourite(String email, Favourite favourite) throws FavouriteAlreadyExistException;

    List<Cart> getCartItemByCustomerEmail(String email);
    List<Favourite> getFavouriteByCustomerEmail(String email);

    Customer deleteCartItem(String email,String itemId) throws Exception;
    Customer deleteFavourite(String email,String itemId) throws Exception;
    Customer deleteAllCustomerItems(String email);


}
