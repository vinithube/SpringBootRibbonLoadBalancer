package com.example.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name="employee",configuration = RibbonClientConfiguration.class)
public class SpringBootRibbonLoadBalancerApplication {

	//https://www.youtube.com/watch?v=ueyVjOnDHYQ&t=1184s
	//this tutorial is not fully functional

	@Autowired
	private RestTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRibbonLoadBalancerApplication.class, args);
	}

	@GetMapping("/empDetail")
    public String invokeEmployee(){
		String URL= "http://localhost:8182/emp/getServerPort";
		return template.getForObject(URL,String.class);
	}
	@Bean
	@LoadBalanced
	public RestTemplate template(){
		return new RestTemplate();
	}
}
