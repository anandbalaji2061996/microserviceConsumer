package com.demo.controllers;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
@RestController
public class ConsumerControllerClient {
	
//	@Autowired
//	private DiscoveryClient discoveryClient;
	
	@GetMapping("/")
	public void get() throws RestClientException, IOException {
		for(int i=0;i<100;i++)
			getEmployee();
	}
	
	public void getEmployee() throws RestClientException, IOException {
		
//		List<InstanceInfo> serviceInstance=discoveryClient.getInstancesById("EMPLOYEE-PRODUCER");
//		
//		System.out.println(serviceInstance.get(0).getHomePageUrl());
		
		String baseUrl="http://localhost:8090";
		
		baseUrl=baseUrl+"/employee";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl,
				HttpMethod.GET, getHeaders(),String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		System.out.println(response.getBody());
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}