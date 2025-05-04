package com.sunat.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.sunat.app.feign")
@SpringBootApplication
public class MsParticipantesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsParticipantesApplication.class, args);
	}

}
