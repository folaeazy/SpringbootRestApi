package com.codewithflash.restapi.controllers;

import com.codewithflash.restapi.exceptions.ErrorDetails;
import com.codewithflash.restapi.exceptions.NotEnoughMoneyException;
import com.codewithflash.restapi.processors.PaymentDetails;
import com.codewithflash.restapi.services.PaymentSystem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentSystem paymentSystem;

    public PaymentController(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment() {
        PaymentDetails paymentDetails = paymentSystem.processPayment();
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);


    }
}
