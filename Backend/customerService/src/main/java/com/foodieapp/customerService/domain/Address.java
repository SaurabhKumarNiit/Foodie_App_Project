package com.foodieapp.customerService.domain;

import org.springframework.data.annotation.Id;

public class Address {
    @Id
    private String houseNo;
    private String landMark;
    private String city;
    private String zipCode;

    public Address() {
    }

    public Address(String houseNo, String landMark, String city, String zipCode) {
        this.houseNo = houseNo;
        this.landMark = landMark;
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNo='" + houseNo + '\'' +
                ", landMark='" + landMark + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
