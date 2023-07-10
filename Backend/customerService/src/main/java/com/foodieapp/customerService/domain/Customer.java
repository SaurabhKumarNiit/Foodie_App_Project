package com.foodieapp.customerService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document
public class Customer {
    private String customerName;
    @Id
    private String email;
    private String password;
    private String mobileNo;
    private String profileDp;
//    private List<Address> addressList;
    private List<Cart> cart=new ArrayList<>();
    private Address address;
    private List<Favourite> favouriteList =new ArrayList<>();


    public Customer() {
    }

    public Customer(String customerName, String email, String password,
                    String mobileNo,String profileDp,Address address,List<Cart> cart,List<Favourite> favouriteList) {

        this.customerName = customerName;
        this.email = email;
        this.password = password;
        this.mobileNo = mobileNo;
        this.address = address;
        this.cart=cart;
        this.favouriteList = favouriteList;
        this.profileDp=profileDp;
//        this.addressList=addressList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    public String getProfileDp() {
        return profileDp;
    }

    public void setProfileDp(String profileDp) {
        this.profileDp = profileDp;
    }

    public List<Favourite> getFavouriteList() {
        return favouriteList;
    }

    public void setFavouriteList(List<Favourite> favouriteList) {
        this.favouriteList = favouriteList;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", address=" + address +
                ", cart=" + cart +
                ", favourite=" + favouriteList +
                '}';
    }
}
