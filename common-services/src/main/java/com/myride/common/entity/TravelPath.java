package com.myride.common.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TravelPath implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private String id;
	
	@Column(name = "lattitude")
	private String lattitude;

	@Column(name = "longitude")
	private String longitude;

	//bi-directional many-to-one association to Trip
	@ManyToOne
	@JoinColumn(name="tripid")
	private Trip trip;


}