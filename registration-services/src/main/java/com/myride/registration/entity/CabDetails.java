package com.myride.registration.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.myride.common.entity.BaseEntity;
import com.myride.registration.constans.VehicleType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
public class CabDetails extends BaseEntity {
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Id
	@Column(name = "ID")
	private String cabId;
	@Column(name = "CAB_NUMBER", nullable = false, unique = true, updatable = true)
	private String cabNumber;
	@Enumerated(EnumType.STRING)
	@Column(name = "VEHICLE_TYPE", nullable = false, updatable = true)
	private VehicleType vehicleType;
	@Column(name = "CAB_REGISTRATION_YEAR", nullable = false, updatable = true)
	private Date registrationYear;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private CabOwner onwer;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cab_id")
	private List<Document> documents;
}
