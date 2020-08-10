package com.myride.notification.subject;

import com.myride.common.entity.Cab;
import com.myride.common.entity.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CabRegistrationState extends SubjectState{
	private Cab cab;
	private User user;
}
