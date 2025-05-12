package com.codewithflash.restapi;

import org.springframework.stereotype.Component;


public interface PaymentService {
    void processPayment(double amount);
}

