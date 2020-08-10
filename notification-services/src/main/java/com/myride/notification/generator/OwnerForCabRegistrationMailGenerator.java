package com.myride.notification.generator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;

import com.myride.common.model.NotificationDetails;
import com.myride.common.model.ServiceType;
import com.myride.common.utils.MyRideUtils;
import com.myride.notification.config.properties.NotificationProperties;
import com.myride.notification.subject.CabRegistrationState;
import com.myride.notification.subject.SubjectState;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OwnerForCabRegistrationMailGenerator extends NotificationGenerator{
	
	private CabRegistrationState cabRegistrationState;
	private String mailBodyTemplate;

	public OwnerForCabRegistrationMailGenerator(NotificationProperties properties, CabRegistrationState cabRegistrationState,
			String mailBodyTemplate) {
		super(properties);
		this.cabRegistrationState = cabRegistrationState;
		this.mailBodyTemplate = mailBodyTemplate;
	}
	
	@Override
	public NotificationDetails generateMailNotification() {
		NotificationDetails notificationDetails = null;		

		if(properties != null) {
			String mailFrom = properties.getFrom();
			String mailToDL = cabRegistrationState.getUser().getEmail();
			String mailSubjectTemplate = properties.getCabRegistrationOwnerSubjectTemplate();
			
			List<String> mailToList = MyRideUtils.getListFromCommaSeparatedString(mailToDL);
			
			String mailSubject = mailSubjectTemplate.replace("{EntityType}", ServiceType.CAB_REGISTRATION.getLabel());
			mailSubject = mailSubjectTemplate.replace("${CAB_NUMBER}", cabRegistrationState.getCab().getCabNumber());
			String mailBody = prepateAndGetMailBody( cabRegistrationState);
			List<String> attachments  =new ArrayList<String>();
			
			notificationDetails = new NotificationDetails(null, mailToList,
					mailFrom, mailSubject, mailBody,
					attachments, ServiceType.CAB_REGISTRATION.getLabel());
		}
		return notificationDetails;
	}

	private String prepateAndGetMailBody(CabRegistrationState cabRegistrationState) {
		
		mailBodyTemplate = mailBodyTemplate.replace("${CAB_NUMBER}", cabRegistrationState.getCab().getCabNumber());
		mailBodyTemplate = mailBodyTemplate.replace("${FIRST_NAME}", cabRegistrationState.getUser().getFirstName());
		mailBodyTemplate = mailBodyTemplate.replace("${COMPANY_NAME}", "MyRide");
		return mailBodyTemplate;
	}

	@Override
	public NotificationDetails generateMessageNotification() {
		throw new NotImplementedException();
	}





}
