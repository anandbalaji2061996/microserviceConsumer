package com.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import com.demo.controllers.ConsumerControllerClient;

@SpringBootApplication
public class MicroserviceEmpConsumerApplication {
	
//	@Autowired
//	private static ConsumerControllerClient consumerControllerClient;

	public static void main(String[] args) throws RestClientException, IOException {
		SpringApplication.run(
				MicroserviceEmpConsumerApplication.class, args);
		
//		ConsumerControllerClient consumerControllerClient=ctx.getBean(ConsumerControllerClient.class);
//		System.out.println(consumerControllerClient);
//		consumerControllerClient.getEmployee();
		
	}

}
