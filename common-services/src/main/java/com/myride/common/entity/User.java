package com.myride.common.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.myride.common.constants.ProfileType;
import com.myride.common.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String userid;

	private String city;

	private String email;

	private String firstName;

	private String lastName;

	private String password;

	private String phone;

	private ProfileType profileType;

	//bi-directional many-to-one association to Cab
	@OneToMany(mappedBy="user")
	private List<Cab> cabs;

	//bi-directional many-to-one association to Trip
	@OneToMany(mappedBy="user")
	private List<Trip> trips;

	//bi-directional many-to-one association to Profile
	@ManyToOne
	@JoinColumn(name="profileId")
	private Profile profile;


	public List<Cab> getCabs() {
		return this.cabs;
	}

	public void setCabs(List<Cab> cabs) {
		this.cabs = cabs;
	}

	public Cab addCab(Cab cab) {
		getCabs().add(cab);
		cab.setUser(this);

		return cab;
	}

	public Cab removeCab(Cab cab) {
		getCabs().remove(cab);
		cab.setUser(null);

		return cab;
	}

	public List<Trip> getTrips() {
		return this.trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	public Trip addTrip(Trip trip) {
		getTrips().add(trip);
		trip.setUser(this);

		return trip;
	}

	public Trip removeTrip(Trip trip) {
		getTrips().remove(trip);
		trip.setUser(null);

		return trip;
	}


}