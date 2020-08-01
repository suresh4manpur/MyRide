package com.myride.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myride.registration.model.CabDetails;
import com.myride.registration.service.RegistrationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins ="*",allowedHeaders = "*")
@Api(value ="/register/v1" , tags = {"Register APIs"})
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@GetMapping(value = "/")
	public ResponseEntity<String> hello() {

		return new ResponseEntity<>("Hello from registration services!",HttpStatus.OK);
	}
@ApiOperation(value = "Register my ride cab",nickname = "registerService" , notes = "Register my ride cab",response = String.class,tags = {"Register APIs"})
	@PostMapping("/register/cab")
	public ResponseEntity<String> registerCab(@RequestBody CabDetails cabDetails) {
		log.info("Initiated Cab registration for Cab Nnumber : {}!", cabDetails.getCabNumber());
		registrationService.registerCab(cabDetails);
		return ResponseEntity.status(HttpStatus.OK).body("Successfully added");
	}

}
