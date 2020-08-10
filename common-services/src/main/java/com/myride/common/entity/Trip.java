package com.myride.common.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the trip database table.
 * 
 */
@Entity
@NamedQuery(name="Trip.findAll", query="SELECT t FROM Trip t")
public class Trip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String tripId;

	private float cost;

	private String destination;

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

	private String source;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_time")
	private Date startTime;

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

	public Trip() {
	}

	public String getTripId() {
		return this.tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

	public float getCost() {
		return this.cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public float getDistance() {
		return this.distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public String getDriverComment() {
		return this.driverComment;
	}

	public void setDriverComment(String driverComment) {
		this.driverComment = driverComment;
	}

	public int getDriverRating() {
		return this.driverRating;
	}

	public void setDriverRating(int driverRating) {
		this.driverRating = driverRating;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getRiderComment() {
		return this.riderComment;
	}

	public void setRiderComment(String riderComment) {
		this.riderComment = riderComment;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<TravelPath> getTravelPaths() {
		return this.travelPaths;
	}

	public void setTravelPaths(List<TravelPath> travelPaths) {
		this.travelPaths = travelPaths;
	}

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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cab getCab() {
		return this.cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

}