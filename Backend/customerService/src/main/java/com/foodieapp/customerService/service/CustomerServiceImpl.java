package com.foodieapp.customerService.service;

import com.foodieapp.customerService.domain.Address;
import com.foodieapp.customerService.domain.Cart;
import com.foodieapp.customerService.domain.Customer;

import com.foodieapp.customerService.domain.Favourite;
import com.foodieapp.customerService.exception.CustomerAlreadyExitsException;
import com.foodieapp.customerService.exception.CustomerNotFoundException;
import com.foodieapp.customerService.exception.FavouriteAlreadyExistException;
import com.foodieapp.customerService.exception.ItemAlreadyExists;
import com.foodieapp.customerService.proxy.CustomerProxy;
import com.foodieapp.customerService.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private final CustomerRepository customerRepository = null;

    private CustomerProxy customerProxy;



    @Autowired
    public CustomerServiceImpl(CustomerProxy customerProxy) {
        this.customerProxy=customerProxy;
    }

    @Override
    public Customer registerCustomer(Customer customer) throws CustomerAlreadyExitsException {
        if(customerRepository.findById(customer.getEmail()).isPresent()){
            throw new CustomerAlreadyExitsException();
        }
        Customer addCustomer= customerRepository.save(customer);

        if(!(addCustomer.getEmail().isEmpty())){
            ResponseEntity responseEntity = customerProxy.saveCustomer(customer);
            System.out.println(responseEntity.getBody());
        }
        return addCustomer;
    }



    @Override
    public List<Customer> getAllCustomers() throws CustomerNotFoundException {

        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByEmail(String email) throws CustomerNotFoundException {
        return customerRepository.findByEmail(email);
    }


    @Override
    public Customer updateCustomerDetails(Customer customer, String email)  {
        Optional<Customer> optionalCustomer = customerRepository.findById(email);
        if(optionalCustomer.isEmpty()){
            return null;
        }

        Customer existingCustomer = optionalCustomer.get();
        if (customer.getCustomerName()!=null){
            existingCustomer.setCustomerName(customer.getCustomerName());
        }
        if (customer.getPassword()!= null){
            existingCustomer.setPassword(customer.getPassword());
        }
        if (customer.getMobileNo()!=null){
            existingCustomer.setMobileNo(customer.getMobileNo());
        }
        if (customer.getProfileDp()!=null){
            existingCustomer.setProfileDp(customer.getProfileDp());
        }
        Address exitsaddress = optionalCustomer.get().getAddress();

            exitsaddress.setHouseNo(customer.getAddress().getHouseNo());
            exitsaddress.setLandMark(customer.getAddress().getLandMark());
            exitsaddress.setCity(customer.getAddress().getCity());
            exitsaddress.setZipCode(customer.getAddress().getZipCode());

        existingCustomer.setAddress(exitsaddress);
        return customerRepository.save(existingCustomer);
    }

    @Override
    public Address getAddressByEmail(String email) throws CustomerNotFoundException {
        if (customerRepository.findById(email).isEmpty()){
            throw new CustomerNotFoundException();
        }
        return customerRepository.findById(email).get().getAddress();
    }

    @Override
    public Customer addItemInCart(String email, Cart cart) throws ItemAlreadyExists {
        Customer customer = customerRepository.findById(email).get();
        List<Cart> cartList=customer.getCart();

        if(customer.getCart().isEmpty()) {
            customer.setCart(Arrays.asList(cart));
        }
        else {

            ListIterator<Cart> cartIterator = cartList.listIterator();
            while (cartIterator.hasNext()) {
                Cart cart1=cartIterator.next();
                if (cart1.getItemId().equals(cart.getItemId())) {

                    cart1.setQuantity(cart1.getQuantity() + 1);
                    customer.setCart(cartList);
                    return customerRepository.save(customer);
                }
            }
                cartList.add(cart);
                customer.setCart(cartList);
        }

        return customerRepository.save(customer);
        }

    @Override
    public Customer updateQuantity(String email, Cart cart,int quantity) {
        Customer customer = customerRepository.findById(email).get();
        List<Cart> cartList=customer.getCart();
        ListIterator<Cart> cartIterator = cartList.listIterator();
        while (cartIterator.hasNext()) {
            Cart cart1=cartIterator.next();

            if(cart1.getQuantity()<1){
                System.out.println("quantity less than 0");
                return customerRepository.save(customer);
            }
            if (cart1.getItemId().equals(cart.getItemId())) {

                cart1.setQuantity( cart1.getQuantity()+(quantity));


                customer.setCart(cartList);
            }
        }

        return customerRepository.save(customer);
    }


    @Override
    public Customer addFavourite(String email, Favourite favourite) throws FavouriteAlreadyExistException
    {

        List<Favourite> favourite1 = customerRepository.findById(email).get().getFavouriteList();

        Iterator<Favourite> favouriteIterator=favourite1.iterator();

        while (favouriteIterator.hasNext()){
            if(favouriteIterator.next().getItemId().equals(favourite.getItemId())){

                throw new FavouriteAlreadyExistException();
            }
        }
        Customer customer = customerRepository.findByEmail(email);
        if(customer.getFavouriteList()==null){
            customer.setFavouriteList(Arrays.asList(favourite));
        }else {
            List<Favourite> customerFavourite=customer.getFavouriteList();
            customerFavourite.add(favourite);
            customer.setFavouriteList(customerFavourite);
        }
        return customerRepository.save(customer);

    }


    @Override
    public List<Cart> getCartItemByCustomerEmail(String email) {
        return customerRepository.findById(email).get().getCart();
    }

    @Override
    public List<Favourite> getFavouriteByCustomerEmail(String email) {
        return customerRepository.findById(email).get().getFavouriteList();
    }

    @Override
    public Customer deleteAllCustomerItems(String email) {
        Customer customer= customerRepository.findById(email).get();
        List<Cart> cart =customer.getCart();
        cart.removeAll(cart);
        return customerRepository.save(customer);
    }

    @Override
    public Customer deleteCartItem(String email,String itemId) throws Exception {
//        boolean result = false;
        if(customerRepository.findById(email).isEmpty())
        {
            throw new Exception();
        }
        Customer customer = customerRepository.findById(email).get();
        List<Cart> cartList = customer.getCart();
        for (Cart cart : cartList) {
            System.out.println(cart);
        }
        List<Cart> existingItem= new ArrayList<>();
//   result = cartList.removeIf(obj->obj.getItemId().equals(itemId));
        Iterator<Cart> cartIterator=cartList.iterator();
        while (cartIterator.hasNext()){
            if (cartIterator.next().getItemId().equals(itemId)){
                cartIterator.remove();
                break;
            }
        }
//        result = cartList.remove();
        if(!cartIterator.hasNext())
        {
            System.out.println("Item Not Found");
        }
        customer.setCart(cartList);
        return customerRepository.save(customer);
    }

    @Override
    public Customer deleteFavourite(String email, String itemId) throws Exception {
        if(customerRepository.findById(email).isEmpty())
        {
            throw new Exception();
        }
        Customer customer = customerRepository.findById(email).get();
        List<Favourite> favouriteList = customer.getFavouriteList();
        for (Favourite cart : favouriteList) {
            System.out.println(cart);
        }
        List<Cart> existingItem= new ArrayList<>();
        Iterator<Favourite> favouriteIterator=favouriteList.iterator();
        while (favouriteIterator.hasNext()){
            if (favouriteIterator.next().getItemId().equals(itemId)){
                favouriteIterator.remove();
                break;
            }
        }
        if(!favouriteIterator.hasNext())
        {
            System.out.println("Favourite Not Found");
        }
        customer.setFavouriteList(favouriteList);
        return customerRepository.save(customer);
    }
}
