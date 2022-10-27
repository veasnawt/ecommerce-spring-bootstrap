package com.example.camboelectro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.camboelectro.repository") 
@EntityScan("com.example.camboelectro.model")
@SpringBootApplication
public class CamboelectroApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamboelectroApplication.class, args);
	}

}
