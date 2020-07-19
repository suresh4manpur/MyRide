package com.myride.registration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myride.common.entity.CabDetailsEntity;
import com.myride.common.model.NotificationDetails;
import com.myride.common.model.ServiceType;
import com.myride.notification.service.NotificationProxyService;
import com.myride.registration.dao.RegistrationDao;
import com.myride.registration.model.CabDetails;
import com.myride.registration.service.RegistrationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	private RegistrationDao registrationDao;

	@Autowired
	private NotificationProxyService notificationProxyService;

	@Override
	public void registerCab(CabDetails cabDetails) {
		log.info("Registering the cab!");
		log.info("Saving cab details {} to database!", cabDetails);
		CabDetailsEntity cabDetailsEntity = new CabDetailsEntity();
		
		//registrationDao.save(cabDetails);
		log.info("Cab details of cab number : {} saved to DB!", cabDetails.getCabNumber());

		log.info("Sending notification for the cab id {}", cabDetails.getCabId());
		//prepareAndGetNotificationDetails(CabDetailsEntity cabDetailsEntity);
		NotificationDetails notificationDetails = new NotificationDetails(cabDetails.getCabId(), "Cab Registration",
				"Congratulations! Your cab has been register successfully!", null, ServiceType.CAB_REGISTRATION.name());
		notificationProxyService.sendNotification(notificationDetails);

		log.info("Cab registration completed successfully!");

	}
	/*
	 * private NotificationDetails prepareAndGetNotificationDetails(CabDetailsEntity
	 * cabDetailsEntity){
	 * 
	 * }
	 */
}
