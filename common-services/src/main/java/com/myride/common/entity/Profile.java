package com.myride.common.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * The persistent class for the profile database table.
 * 
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="profile_Id")
	private String profileId;

	@Column(name="rating")
	private int rating;
	@Column(name="trips")
	private int trips;

	@Column(name="user_photo_id")
	private String userPhotoId;

	@Column(name="valid_identity_id")
	private String validIdentityId;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="profile")
	private List<User> users;

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