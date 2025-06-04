package com.codewithflash.restapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AccountNotFoundException extends  RuntimeException{

    public AccountNotFoundException(long id){
        super("User with Id :" + id + "does not exist");
    }
}
