package com.myride.registration.service;

import org.springframework.stereotype.Service;

import com.myride.registration.model.CabDetails;

public interface RegistrationService {
	public void registerCab(CabDetails cabDetails);
}
