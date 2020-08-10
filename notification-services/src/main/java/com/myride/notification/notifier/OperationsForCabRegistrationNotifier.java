package com.myride.notification.notifier;

import java.util.Observable;
import java.util.Observer;

import org.apache.commons.lang3.NotImplementedException;

import com.myride.common.model.NotificationDetails;
import com.myride.notification.config.properties.NotificationProperties;
import com.myride.notification.subject.NotificationSubject;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class OperationsForCabRegistrationNotifier implements Observer {
	
	private NotificationProperties properties;
	private String mailBodyTemplate;
	@Override
	public void update(Observable o, Object arg) {
		
	}

	NotificationDetails genrateMailNofication(NotificationSubject notificationSubject) {
		
		throw new NotImplementedException();
	}

	NotificationDetails genrateMessageNofication(NotificationSubject notificationSubject) {
		throw new NotImplementedException();
	}

}
