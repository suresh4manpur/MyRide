package com.myride.notification.notifier;

import java.util.Observable;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;

import com.myride.common.model.NotificationDetails;
import com.myride.notification.config.properties.NotificationProperties;
import com.myride.notification.subject.NotificationSubject;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class OperationsForCabRegistrationNotifier extends Notifier {
	
	private NotificationProperties properties;
	private String mailBodyTemplate;
	@Override
	public void update(Observable o, Object arg) {
		
	}

	@Override
	NotificationDetails genrateMailNofication(NotificationSubject notificationSubject) {
		
		throw new NotImplementedException();
	}

	@Override
	NotificationDetails genrateMessageNofication(NotificationSubject notificationSubject) {
		throw new NotImplementedException();
	}

}
