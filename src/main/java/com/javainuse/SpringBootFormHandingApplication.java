package com.javainuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages={"com.javainuse"})
public class SpringBootFormHandingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFormHandingApplication.class, args);
	}
}