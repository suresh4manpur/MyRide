package com.myride.registration.service;

import com.myride.common.entity.Cab;
import com.myride.common.entity.User;

public interface RegistrationService {
	public void registerCab(Cab cab);
	public void registerUser(User user);
	
}
