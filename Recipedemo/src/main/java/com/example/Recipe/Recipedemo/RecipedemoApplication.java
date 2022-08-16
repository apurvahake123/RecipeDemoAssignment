package com.example.Recipe.Recipedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class RecipedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipedemoApplication.class, args);
		log.info("recipeinfo");
	}

}
