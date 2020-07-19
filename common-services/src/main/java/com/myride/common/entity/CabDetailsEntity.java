package com.myride.common.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CabDetailsEntity {
	 @Id
	 private String cabId;
	 private String cabNumber;
	 private Date registratinoYear;
	 //private OwnerEntity ownerEntity;
}
