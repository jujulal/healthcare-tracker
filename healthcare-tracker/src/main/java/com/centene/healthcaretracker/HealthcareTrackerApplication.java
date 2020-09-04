package com.centene.healthcaretracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.centene.healthcaretracker")
public class HealthcareTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthcareTrackerApplication.class, args);
	}

}
