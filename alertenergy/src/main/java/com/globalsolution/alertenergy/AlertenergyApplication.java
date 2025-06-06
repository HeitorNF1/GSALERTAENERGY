package com.globalsolution.alertenergy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.globalsolution.alertenergy.client")
public class AlertenergyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlertenergyApplication.class, args);
	}

}
