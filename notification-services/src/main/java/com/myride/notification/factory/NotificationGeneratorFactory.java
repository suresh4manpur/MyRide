package com.myride.notification.factory;

import com.myride.notification.config.properties.NotificationProperties;
import com.myride.notification.generator.NotificationGenerator;
import com.myride.notification.generator.OwnerForCabRegistrationMailGenerator;
import com.myride.notification.subject.CabRegistrationState;

public class NotificationGeneratorFactory {
	
	
	public static NotificationGenerator getOwnerForCabRegistrationMailGenerator(CabRegistrationState cabRegistrationState, NotificationProperties properties, String mailBody){
		return new OwnerForCabRegistrationMailGenerator(properties,cabRegistrationState, mailBody);
	}
/*	
	public static NotificationDetails getNotificationDetail(NotificationGenerator notificationGenerator) {
		NotificationDetails notificationDetails = notificationGenerator.createNotification();
		
		return notificationDetails;
		Set<String> mailToList = new HashSet<>();
		mailToList.add(mailTo);
		subject = subject.replace("{EntityType}", ServiceType.CAB_REGISTRATION.getLabel());
		body = body.replace("{EntityType}", ServiceType.CAB_REGISTRATION.getLabel());
		NotificationDetails notificationDetails = new NotificationDetails(cab.getCabNumber(), mailToList,
				mailFrom, subject, body,
				null, ServiceType.CAB_REGISTRATION.getLabel());

		return notificationDetails;
	}
	*/
}
