package com.myride.common.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the travel_path database table.
 * 
 */
@Entity
@Table(name="travel_path")
@NamedQuery(name="TravelPath.findAll", query="SELECT t FROM TravelPath t")
public class TravelPath implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String lattitude;

	private String longitude;

	//bi-directional many-to-one association to Trip
	@ManyToOne
	@JoinColumn(name="tripid")
	private Trip trip;

	public TravelPath() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLattitude() {
		return this.lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Trip getTrip() {
		return this.trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

}