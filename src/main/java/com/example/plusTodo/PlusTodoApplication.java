package com.example.plusTodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PlusTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlusTodoApplication.class, args);
	}

}
