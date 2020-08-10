package com.myride.notification.generator;

import com.myride.common.model.NotificationDetails;
import com.myride.notification.config.properties.NotificationProperties;
import com.myride.notification.subject.SubjectState;

public abstract class NotificationGenerator {
	protected NotificationProperties properties;
	
	public NotificationGenerator(NotificationProperties properties) {
		this.properties = properties;
	}
	abstract  NotificationDetails generateMailNotification();
	abstract  NotificationDetails generateMessageNotification();
}
