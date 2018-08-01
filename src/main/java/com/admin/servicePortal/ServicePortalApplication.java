package com.admin.servicePortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.admin")
public class ServicePortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicePortalApplication.class, args);
	}
}
