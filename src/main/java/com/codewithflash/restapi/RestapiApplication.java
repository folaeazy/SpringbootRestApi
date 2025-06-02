package com.codewithflash.restapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestapiApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestapiApplication.class, args);
		//var orderService = context.getBean(OrderService.class);

		//orderService.placeOrder();

	}

}
