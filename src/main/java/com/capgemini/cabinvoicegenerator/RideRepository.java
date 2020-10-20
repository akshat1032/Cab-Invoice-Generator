package com.capgemini.cabinvoicegenerator;

import java.util.HashMap;
import java.util.Map;

public class RideRepository {
	
	private final Map<String,Rides[]> USER_RIDE_DETAILS = new HashMap<String, Rides[]>();
	public RideRepository(String userId, Rides[] rides) {
		USER_RIDE_DETAILS.put(userId, rides);
	}
	
	public Rides[] getRides(String userId) {
		return USER_RIDE_DETAILS.get(userId);
	}

}
