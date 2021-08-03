package com.projectvilla.villabooking;

import com.projectvilla.villabooking.storage.StorageProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class VillabookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(VillabookingApplication.class, args);
	}

}
