package com.myride.common.model;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NotificationDetails {
	private String id;
	private Set<String> to;
	private String from;
	private String subject;
	private String body;
	private List<String> attachment;
	private String entityType;
}
