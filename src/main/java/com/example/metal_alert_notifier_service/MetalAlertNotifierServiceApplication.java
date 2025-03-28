package com.example.metal_alert_notifier_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MetalAlertNotifierServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetalAlertNotifierServiceApplication.class, args);
	}

}
