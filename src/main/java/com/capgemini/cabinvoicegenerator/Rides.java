package com.capgemini.cabinvoicegenerator;

public class Rides {

	private double distance, time;

	public Rides(double distance, double time) {
		this.distance = distance;
		this.time = time;
	}

	// @return the distance
	public double getDistance() {
		return distance;
	}

	// @return the time
	public double getTime() {
		return time;
	}

}
