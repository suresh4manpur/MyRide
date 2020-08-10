package com.myride.registration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myride.common.entity.Cab;
import com.myride.common.entity.User;
import com.myride.registration.repository.CabRepository;
import com.myride.registration.service.RegistrationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	private CabRepository cabRepository;


	@Override
	public void registerCab(Cab cab) {
		log.info("Registering the cab!");
		log.info("Saving cab details {} to database!", cab);
		
		cabRepository.save(cab);

		//NotificationDetails notificationDetails = prepareAndGetNotificationDetails(cab);

		//notificationProxyService.sendNotification(notificationDetails);
		log.info("Cab registration completed successfully!");
		
	}

	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		
	}
	/*
	 * private NotificationDetails prepareAndGetCabNotificationToOwner(Cab cab, User
	 * user) { NotificationGenerator notificationGenerator = new
	 * CabNotificationGenerator(); Set<String> mailToList = new HashSet<>();
	 * mailToList.add(mailTo); subject = subject.replace("{EntityType}",
	 * ServiceType.CAB_REGISTRATION.getLabel()); body = body.replace("{EntityType}",
	 * ServiceType.CAB_REGISTRATION.getLabel()); NotificationDetails
	 * notificationDetails = new NotificationDetails(cab.getCabNumber(), mailToList,
	 * mailFrom, subject, body, null, ServiceType.CAB_REGISTRATION.getLabel());
	 * 
	 * return notificationDetails; } private NotificationDetails
	 * prepareAndGetNotificationDetailsForUser(User user) { Set<String> mailToList =
	 * new HashSet<>(); mailToList.add(mailTo); subject =
	 * subject.replace("{EntityType}", ServiceType.CAB_REGISTRATION.getLabel());
	 * body = body.replace("{EntityType}", ServiceType.CAB_REGISTRATION.getLabel());
	 * NotificationDetails notificationDetails = new
	 * NotificationDetails(cab.getCabNumber(), mailToList, mailFrom, subject, body,
	 * null, ServiceType.CAB_REGISTRATION.getLabel());
	 * 
	 * return notificationDetails; }
	 */
}
