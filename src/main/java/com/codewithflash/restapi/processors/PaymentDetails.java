package com.codewithflash.restapi.processors;

public class PaymentDetails {
    private  String id;
    private double amount;


    public static PaymentDetails of(String id , double amount) {
        PaymentDetails  paymentDetails = new PaymentDetails();
        paymentDetails.setId(id);
        paymentDetails.setAmount(amount);
        return paymentDetails;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setId(String id) {
        this.id  = id;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }
}
