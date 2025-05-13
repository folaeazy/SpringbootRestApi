package com.codewithflash.restapi.controllers;

import com.codewithflash.restapi.exceptions.ErrorDetails;
import com.codewithflash.restapi.exceptions.NotEnoughMoneyException;
import com.codewithflash.restapi.processors.PaymentDetails;
import com.codewithflash.restapi.services.PaymentSystem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentController {

    private final static Logger logger = Logger.getLogger(PaymentController.class.getName());


//    public PaymentController(PaymentSystem paymentSystem) {
//        this.paymentSystem = paymentSystem;
//    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment(
            @RequestBody PaymentDetails paymentDetails,
            @RequestHeader String requestId) {
        logger.info("Received request with ID :  " + paymentDetails.getId() + "Payment amount:  " + paymentDetails.getAmount());
        paymentDetails.setId(UUID.randomUUID().toString());
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("requestId", requestId)
                .body(paymentDetails);
    }
}
