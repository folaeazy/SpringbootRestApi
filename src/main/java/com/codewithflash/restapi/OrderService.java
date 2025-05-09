package com.codewithflash.restapi;

import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private  PaymentService paymentService;
    public OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    public void placeOrder(){
       paymentService.processPayment(100);
    }
}
