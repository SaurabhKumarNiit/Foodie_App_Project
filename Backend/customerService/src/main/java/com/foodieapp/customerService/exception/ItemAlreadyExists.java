package com.foodieapp.customerService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Item Already Exits in Cart")
public class ItemAlreadyExists extends Exception{
}
