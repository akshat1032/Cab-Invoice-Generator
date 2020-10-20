package com.capgemini.cabinvoicegenerator;

public class CabInvoiceGenerator {

	public enum RideCategory {
		NORMAL_RIDES, PREMIUM_RIDES;
	}

	// Constant value for cost
	private static final double COST_PER_KM = 10;
	private static final double COST_PER_MINUTE = 1;
	private static final double MINIMUM_FARE = 5;
	private static final double COST_PER_KM_PREMIUM = 15;
	private static final double COST_PER_MINUTE_PREMIUM = 2;
	private static final double MINIMUM_FARE_PREMIUM = 20;

	private final RideRepository USER_RIDE_DETAIL;

	public CabInvoiceGenerator() {
		this.USER_RIDE_DETAIL = null;
	}

	// Initializing the user ride detail field
	public CabInvoiceGenerator(String userId, Rides[] rides) {
		USER_RIDE_DETAIL = new RideRepository(userId, rides);
	}

	// Returning total fare
	public double calculateTotalFare(double distance, double time, RideCategory rideCategory) {
		double totalFare = 0.0;
		if (rideCategory.equals(RideCategory.NORMAL_RIDES)) {
			totalFare = distance * COST_PER_KM + time * COST_PER_MINUTE;
			return Math.max(totalFare, MINIMUM_FARE);
		}
		totalFare = distance * COST_PER_KM_PREMIUM + time * COST_PER_MINUTE_PREMIUM;
		return Math.max(totalFare, MINIMUM_FARE_PREMIUM);
	}

	// Returning enhanced invoice
	public InvoiceSummary calculateTotalFare(String userId, RideCategory rideCategory) {
		Rides[] rides = USER_RIDE_DETAIL.getRides(userId);
		double aggregateFare = 0.0;
		for (Rides ride : rides) {
			aggregateFare += this.calculateTotalFare(ride.getDistance(), ride.getTime(), rideCategory);
		}
		return new InvoiceSummary(rides.length, aggregateFare);
	}
}
