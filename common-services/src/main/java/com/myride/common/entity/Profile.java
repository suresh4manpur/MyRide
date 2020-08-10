package com.myride.common.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the profile database table.
 * 
 */
@Entity
@NamedQuery(name="Profile.findAll", query="SELECT p FROM Profile p")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String profileId;

	private int rating;

	private int trips;

	@Column(name="user_photo_id")
	private String userPhotoId;

	@Column(name="valid_identity_id")
	private String validIdentityId;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="profile")
	private List<User> users;

	public Profile() {
	}

	public String getProfileId() {
		return this.profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getTrips() {
		return this.trips;
	}

	public void setTrips(int trips) {
		this.trips = trips;
	}

	public String getUserPhotoId() {
		return this.userPhotoId;
	}

	public void setUserPhotoId(String userPhotoId) {
		this.userPhotoId = userPhotoId;
	}

	public String getValidIdentityId() {
		return this.validIdentityId;
	}

	public void setValidIdentityId(String validIdentityId) {
		this.validIdentityId = validIdentityId;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setProfile(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setProfile(null);

		return user;
	}

}