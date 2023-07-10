package com.foodieapp.restaurantService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Restaurant Already Exist please add different !")
public class RestaurantAlreadyExistException extends Exception{
}
