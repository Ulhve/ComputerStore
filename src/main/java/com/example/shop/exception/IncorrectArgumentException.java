package com.example.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IncorrectArgumentException extends RuntimeException {
    public IncorrectArgumentException(){
        super();
    }
    public IncorrectArgumentException(String stringValue){
        super(String.format("incorrect argument with value=%d", stringValue));
    }
}
