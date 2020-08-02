package com.myride.registration.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.myride.common.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
public class CabOwner extends BaseEntity {
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ID")
	@Id
	private String Id;
	@Column(name = "first_name", nullable = false, updatable = false)
	private String firstName;
	@Column(name = "last_name", nullable = false, updatable = false)
	private String lastName;
	@Column(name = "phone", nullable = false, updatable = true)
	private String phone;
	@Column(name = "email_id", unique = true, nullable = false, updatable = false)
	private String emailId;	
	@Embedded
	private Address address;
}
