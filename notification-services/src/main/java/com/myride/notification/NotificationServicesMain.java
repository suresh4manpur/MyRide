package com.myride.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.myride"})
public class NotificationServicesMain {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServicesMain.class, args);
	}

}
