package com.myride.notification.subject;

import java.util.Observable;
import java.util.Observer;

public class NotificationSubject extends Observable{
	
	private SubjectState state;

	public SubjectState getState() {
		return state;
	}

	public void setState(SubjectState state) {
		this.state = state;
		sendNotificationToObservers();
	}

	public void register(Observer observer) {
		this.addObserver(observer);
	}

	public void sendNotificationToObservers() {
		setChanged();
		this.notifyObservers();
		clearChanged();
	}
}
