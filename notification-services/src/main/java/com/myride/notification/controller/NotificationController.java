package com.myride.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myride.notification.MailNotificationManager;
import com.myride.notification.model.NotificationDetails;
import com.myride.notification.subject.CabRegistrationState;
import com.myride.notification.subject.SubjectState;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = { "Notification APIs" })
public class NotificationController {

	@Autowired
	private MailNotificationManager mailNotificationManager;

	// @ApiOperation(value = "Register my ride cab",nickname = "registerService" ,
	// notes = "Register my ride cab",response = String.class,tags = {"Register
	// APIs"})
	@GetMapping(value = "/")
	public String hello() {
		return "Hello from notification services!";
	}

	@ApiOperation(value = "Send mail ride cab", nickname = "sendMail", notes = "Send mail ride cab", response = String.class, tags = {
			"Notification APIs" })
	@PostMapping("/v2/send-mail")
	public ResponseEntity<String> sendNotification(@RequestBody NotificationDetails cabRegistrationNotification) {
		log.info("Sending the mail - " + cabRegistrationNotification);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@ApiOperation(value = "Send mail ride cab", nickname = "sendMail", notes = "Send mail ride cab", response = String.class, tags = {
			"Notification APIs" })
	@PostMapping("/v1/send-mail")
	public ResponseEntity<String> sendNotification(@RequestBody CabRegistrationState subjectState) {
		log.info("Started to send the mail for  - " + subjectState);
		mailNotificationManager.sendMail((SubjectState)subjectState);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
