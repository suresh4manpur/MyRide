package com.myride.notification.notifier;

import java.util.Observable;

import com.myride.common.model.NotificationDetails;
import com.myride.notification.config.properties.NotificationProperties;
import com.myride.notification.generator.OwnerForCabRegistrationMailGenerator;
import com.myride.notification.subject.CabRegistrationState;
import com.myride.notification.subject.NotificationSubject;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class OwnerForCabRegistrationNotifier extends Notifier{
	
	private NotificationProperties properties;
	private String mailBodyTemplate;

	@Override
	public void update(Observable o, Object arg) {
		NotificationSubject notificationSubject = (NotificationSubject)o;
		NotificationDetails notificationDetails = genrateMailNofication(notificationSubject);

		log.info("Sending the mail to {}", notificationDetails);
		
	}

	@Override
	NotificationDetails genrateMailNofication(NotificationSubject notificationSubject) {
		CabRegistrationState cabRegistrationState = (CabRegistrationState)notificationSubject.getState();
		OwnerForCabRegistrationMailGenerator generator = new OwnerForCabRegistrationMailGenerator(properties, cabRegistrationState, mailBodyTemplate);
		return generator.generateMailNotification();
	}

	@Override
	NotificationDetails genrateMessageNofication(NotificationSubject notificationSubject) {
		// TODO Auto-generated method stub
		return null;
	}

}
