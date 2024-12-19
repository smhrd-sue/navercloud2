package com.smhrd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import jakarta.servlet.Filter;

@SpringBootApplication
public class SpringBoot01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot01Application.class, args);
	}
	
	 

}
