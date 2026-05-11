package com.unir.operaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OperacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OperacionesApplication.class, args);
	}

}
