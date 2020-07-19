package com.myride.common.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CabDetailsEntity {
	 @Id
	 private String cabId;
	 private String cabNumber;
	 private Date registratinoYear;
	 //private OwnerEntity ownerEntity;
}
