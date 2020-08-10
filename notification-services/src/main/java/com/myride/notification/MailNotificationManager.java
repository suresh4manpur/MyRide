package com.myride.notification;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myride.common.utils.MyRideUtils;
import com.myride.notification.config.properties.NotificationProperties;
import com.myride.notification.notifier.OperationsForCabRegistrationNotifier;
import com.myride.notification.notifier.OwnerForCabRegistrationNotifier;
import com.myride.notification.subject.CabRegistrationState;
import com.myride.notification.subject.NotificationSubject;
import com.myride.notification.subject.SubjectState;

@Component
public class MailNotificationManager {

	@Autowired
	private NotificationProperties notificationProperties;
	
	Map<String,NotificationSubject> map = new HashMap<>();
	NotificationSubject notificationSubject;
	
	@PostConstruct
	public void init() {
		NotificationSubject notificationSubject = new NotificationSubject();
		notificationSubject.setState(new CabRegistrationState());
		notificationSubject.addObserver(new OwnerForCabRegistrationNotifier(notificationProperties,MyRideUtils.readFullFile("mail-template/mailToOwnerForCabRegistration.html")));
		notificationSubject.addObserver(new OperationsForCabRegistrationNotifier(notificationProperties,MyRideUtils.readFullFile("mail-template/mailToOperationsForCabRegistration.html")));
		map.put(CabRegistrationState.class.getName(), notificationSubject);
	}
	
	public void sendMail(SubjectState subjectState) {
		NotificationSubject notificationSubject = map.get(subjectState.getClass().getName());
		notificationSubject.setState(subjectState);
	}

	
}
