package com.myride.registration.entity;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Address {
	private String addressLine1;
	private String addressLine2;
	private String district;
	private String state;
	private String country;
	private String city;
	private String pinCode;

}
