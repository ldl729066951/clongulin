package com.castor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.castor.database.entities"})
public class ClongulinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClongulinApplication.class, args);
	}
}
