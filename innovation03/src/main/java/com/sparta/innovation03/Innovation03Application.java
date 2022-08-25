package com.sparta.innovation03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class Innovation03Application {
	public Innovation03Application() {
	}

	public static void main(String[] args) {
		SpringApplication.run(Innovation03Application.class, args);
	}

}
