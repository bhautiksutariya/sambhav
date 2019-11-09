package com.sambhav.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan({"com.sambhav.model"})
public class SambhavApplication {

	public static void main(String[] args) {
		SpringApplication.run(SambhavApplication.class, args);
	}

}
