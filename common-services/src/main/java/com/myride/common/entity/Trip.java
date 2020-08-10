package com.myride.common.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Trip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="trip_id")
	private String tripId;

	@Column(name="cost")
	private float cost;

	@Column(name="destination")
	private String destination;

	@Column(name="destination")
	private float distance;

	@Column(name="driver_comment")
	private String driverComment;

	@Column(name="driver_rating")
	private int driverRating;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_time")
	private Date endTime;

	@Column(name="rider_comment")
	private String riderComment;

	@Column(name="source")
	private String source;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_time")
	private Date startTime;

	@Column(name="status")
	private int status;

	//bi-directional many-to-one association to TravelPath
	@OneToMany(mappedBy="trip")
	private List<TravelPath> travelPaths;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="driverId")
	private User user;

	//bi-directional many-to-one association to Cab
	@ManyToOne
	@JoinColumn(name="cabId")
	private Cab cab;

	public TravelPath addTravelPath(TravelPath travelPath) {
		getTravelPaths().add(travelPath);
		travelPath.setTrip(this);

		return travelPath;
	}

	public TravelPath removeTravelPath(TravelPath travelPath) {
		getTravelPaths().remove(travelPath);
		travelPath.setTrip(null);

		return travelPath;
	}

}