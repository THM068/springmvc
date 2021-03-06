package com.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.mvc"})
public class MvcTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcTutorialApplication.class, args);
	}
}
