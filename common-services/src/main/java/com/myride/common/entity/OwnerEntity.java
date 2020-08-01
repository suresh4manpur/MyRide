package com.myride.common.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;


//@Entity
public class OwnerEntity {
	@Id
	private String ownerId;
	
	private String firstName;
	private String lastName;
	@Transient
	private AddressEntity addressEntity;
	private String phone;
	private String emailId;
}
