package com.foodieapp.customerService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Favourite Already Exits in Cart")
public class FavouriteAlreadyExistException extends Exception{
}
