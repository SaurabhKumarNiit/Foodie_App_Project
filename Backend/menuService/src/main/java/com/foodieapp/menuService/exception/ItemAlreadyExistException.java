package com.foodieapp.menuService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "item Already Exits")
public class ItemAlreadyExistException extends Exception{
}
