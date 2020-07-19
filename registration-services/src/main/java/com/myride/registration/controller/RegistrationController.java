package com.myride.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myride.registration.model.CabDetails;
import com.myride.registration.service.RegistrationService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@GetMapping(value = "/")
	public String hello() {

		return "Hello from registration services!";
	}

	@PostMapping("/register/cab")
	public ResponseEntity<String> registerCab(@RequestBody CabDetails cabDetails) {
		log.info("Initiated Cab registration for Cab Nnumber : {}!", cabDetails.getCabNumber());
		registrationService.registerCab(cabDetails);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
