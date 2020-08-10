package com.myride.notification.service;

import com.myride.notification.subject.SubjectState;

public interface MailNotificationService {
	public void sendMail(SubjectState subjectState);
}
