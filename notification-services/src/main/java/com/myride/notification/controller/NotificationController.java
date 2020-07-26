package com.myride.notification.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myride.common.exception.MyRideException;
import com.myride.notification.model.NotificationDetails;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class NotificationController {

	@GetMapping(value = "/")
	public String hello() {
		return "Hello from notification services!";
	}

	@PostMapping("/v1/send-mail")
	public ResponseEntity<String> sendNotification(@RequestBody NotificationDetails cabRegistrationNotification) {
		log.info("Sending the mail - " + cabRegistrationNotification);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
