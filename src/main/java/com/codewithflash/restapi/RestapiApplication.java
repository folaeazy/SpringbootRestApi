package com.codewithflash.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestapiApplication {

	public static void main(String[] args) {
		//SpringApplication.run(RestapiApplication.class, args);
		var orderService = new OrderService(new PaypalPaymentService());
		orderService.placeOrder();
	}

}
