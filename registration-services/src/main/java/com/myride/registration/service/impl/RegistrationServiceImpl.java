package com.myride.registration.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${cab.registration.request.mail.to}")
	private String mailTo;
	
	@Value("${cab.registration.request.mail.subject}")
	private String subject;
	
	@Value("${cab.registration.request.mail.body}")
	private String body;


	@Override
	public void registerCab(CabDetails cabDetails) {
		log.info("Registering the cab!");
		log.info("Saving cab details {} to database!", cabDetails);
		CabDetailsEntity cabDetailsEntity = new CabDetailsEntity();

		// registrationDao.save(cabDetails);
		log.info("Cab details of cab number : {} saved to DB!", cabDetails.getCabNumber());

		log.info("Sending notification for the cab id {}", cabDetails.getCabNumber());
		// prepareAndGetNotificationDetails(CabDetailsEntity cabDetailsEntity);

		NotificationDetails notificationDetails = prepareAndGetNotificationDetails(cabDetailsEntity);

		notificationProxyService.sendNotification(notificationDetails);
		log.info("Cab registration completed successfully!");

	}

	private NotificationDetails prepareAndGetNotificationDetails(CabDetailsEntity cabDetailsEntity) {
		Set<String> mailToList = new HashSet<>();
		mailToList.add(mailTo);
		subject = subject.replace("{EntityType}", ServiceType.CAB_REGISTRATION.getLabel());
		body = body.replace("{EntityType}", ServiceType.CAB_REGISTRATION.getLabel());
		NotificationDetails notificationDetails = new NotificationDetails(cabDetailsEntity.getCabNumber(), mailToList,
				"cab.owner@gmail.com", subject, body,
				null, ServiceType.CAB_REGISTRATION.getLabel());

		return notificationDetails;
	}
	
}
