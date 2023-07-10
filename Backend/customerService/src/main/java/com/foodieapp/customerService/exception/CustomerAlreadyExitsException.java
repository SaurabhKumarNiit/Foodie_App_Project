package com.foodieapp.customerService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.ALREADY_REPORTED,reason = "Customer Already Register")
public class CustomerAlreadyExitsException extends Exception{
}
