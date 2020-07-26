package com.myride.registration.service.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.myride.common.constants.ErrorCodes;
import com.myride.common.entity.CabDetailsEntity;
import com.myride.common.exception.InvalidRequestException;
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
	
	@Value("${cab.registration.request.mail.from}")
	private String mailFrom;


	//current user
	@Override
	public void registerCab(CabDetails cabDetails) {
		log.info("Registering the cab!");
		log.info("Saving cab details {} to database!", cabDetails);
		CabDetailsEntity cabDetailsEntity = new CabDetailsEntity();

		// registrationDao.save(cabDetails);
		log.info("Cab details of cab number : {} saved to DB!", cabDetails.getCabNumber());

		log.info("Sending notification for the cab id {}", cabDetails.getCabNumber());
		validate(cabDetails);
		// prepareAndGetNotificationDetails(CabDetailsEntity cabDetailsEntity);

		NotificationDetails notificationDetails = prepareAndGetNotificationDetails(cabDetailsEntity);

		notificationProxyService.sendNotification(notificationDetails);
		log.info("Cab registration completed successfully!");

	}

	private void validate(CabDetails cabDetails) {
		boolean isInvalidEntity = false;
		Map<String, String> errorMap = new HashMap();

		if(StringUtils.isEmpty(cabDetails.getCabNumber())) {
			isInvalidEntity = true;
			errorMap.put("CabNumber",cabDetails.getCabNumber());
		}
		if(cabDetails.getRegistratinoYear() != null) {
			Date date = cabDetails.getRegistratinoYear();
			if(date.after(new Date())) {
				isInvalidEntity = true;
				errorMap.put("RegistratinoYear",cabDetails.getCabNumber());	
			}

		}
		if(isInvalidEntity) {
			throw new InvalidRequestException("Cab Details validation error", null, ErrorCodes.INVALID_ENTITY.getErrorCode());
		}
		log.info("Validation of Cab details is completed suscessfull!");
	}

	private NotificationDetails prepareAndGetNotificationDetails(CabDetailsEntity cabDetailsEntity) {
		Set<String> mailToList = new HashSet<>();
		mailToList.add(mailTo);
		subject = subject.replace("{EntityType}", ServiceType.CAB_REGISTRATION.getLabel());
		body = body.replace("{EntityType}", ServiceType.CAB_REGISTRATION.getLabel());
		NotificationDetails notificationDetails = new NotificationDetails(cabDetailsEntity.getCabNumber(), mailToList,
				mailFrom, subject, body,
				null, ServiceType.CAB_REGISTRATION.getLabel());

		return notificationDetails;
	}
	
}
