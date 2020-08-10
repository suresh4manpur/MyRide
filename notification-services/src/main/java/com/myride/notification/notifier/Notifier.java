package com.myride.notification.notifier;

import java.util.Observer;

import com.myride.common.model.NotificationDetails;
import com.myride.notification.subject.NotificationSubject;

public abstract class Notifier implements Observer{
	 abstract NotificationDetails genrateMailNofication(NotificationSubject observable);
	 abstract NotificationDetails genrateMessageNofication(NotificationSubject observable);
}
