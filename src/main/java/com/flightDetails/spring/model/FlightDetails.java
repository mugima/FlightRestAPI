package com.flightDetails.spring.model;

import java.io.Serializable;
import java.util.Date;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@SuppressWarnings("unused")
public class FlightDetails implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;
	private int flightID;
	public int getFlightID() {
		return flightID;
	}
	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}
	private String flightName;
	private Date startDate;
	private String route; 
	
	
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
