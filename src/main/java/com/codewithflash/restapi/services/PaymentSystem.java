package com.codewithflash.restapi.services;


import com.codewithflash.restapi.exceptions.NotEnoughMoneyException;
import com.codewithflash.restapi.processors.PaymentDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class PaymentSystem {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();

    }

}
