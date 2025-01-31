package com.sambhav;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EntityScan(basePackageClasses = { 
		SambhavApplication.class,
		Jsr310JpaConverters.class 
})
/*@EnableJpaRepositories(basePackages = "com.sambhav.repository")
@ComponentScan({"com.sambhav.service","com.sambhav.controller","com.sambhav.security"})
@EntityScan({"com.sambhav.model"})*/
public class SambhavApplication {
	
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(SambhavApplication.class, args);
	}

}
