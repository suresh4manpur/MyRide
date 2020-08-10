package com.myride.notification.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myride.notification.MailNotificationManager;
import com.myride.notification.config.properties.NotificationProperties;
import com.myride.notification.service.MailNotificationService;
import com.myride.notification.subject.NotificationSubject;
import com.myride.notification.subject.SubjectState;

@Service
public class MailNotificationServiceImpl implements MailNotificationService{
	
	@Autowired
	private NotificationProperties notificationProperties;
	
	MailNotificationManager mailNotificationManager;  


	@Override
	public void sendMail(SubjectState subjectState) {
		
	
	}

}
