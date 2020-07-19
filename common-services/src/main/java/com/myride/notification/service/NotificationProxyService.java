package com.myride.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.myride.common.config.CommonUtils;
import com.myride.common.constants.RestEndpoints;
import com.myride.common.model.NotificationDetails;
import com.myride.common.service.GenericRestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NotificationProxyService {

	@Autowired
	private GenericRestTemplate<NotificationDetails> genericRestTemplate;
	
	@Value(value = "${notification.application.service.url}")
	private String notificationServiceUrl;
	
	public void sendNotification( NotificationDetails notificationDetails ) {
		log.info("Sending notification for id {} for entity type {} to restendpoint {}",notificationDetails.getId(), notificationDetails.getEntityType(),
				                 CommonUtils.prepareAndGetResEnpointUrl(notificationServiceUrl,RestEndpoints.NOTIFICATION_SERVICE_SEND_MAIL.getRestEndPoinUrl()));
		genericRestTemplate.post(CommonUtils.prepareAndGetResEnpointUrl(notificationServiceUrl,RestEndpoints.NOTIFICATION_SERVICE_SEND_MAIL.getRestEndPoinUrl()), 
				notificationDetails, NotificationDetails.class);
	}


}


