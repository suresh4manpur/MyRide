package com.myride.notification.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;


import lombok.Data;

@Configuration
@PropertySource("classpath:mail.properties")
@ConfigurationProperties(prefix = "mail")
@Validated
@Data
public class NotificationProperties {
	private String from;
	private String cabRegistrationToOwner;
	private String cabRegistrationToOperations;
	private String cabRegistrationOwnerSubjectTemplate;

}
