package com.depaul.se452.group8.Espy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class EspyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EspyApplication.class, args);
	}

}
