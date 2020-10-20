package com.capgemini.cabinvoicegenerator;

public class CabInvoiceGenerator {

	// Constant value for cost
	private static final double COST_PER_KM = 10;
	private static final double COST_PER_MINUTE = 1;
	private static final double MINIMUM_FARE = 5;

	// Returning total fare
	public double calculateTotalFare(double distance, double time) {
		double totalFare = distance * COST_PER_KM + time * COST_PER_MINUTE;
		if (totalFare < MINIMUM_FARE) {
			return MINIMUM_FARE;
		}
		return totalFare;
	}

	// Returning aggregate fare
	public double calculateTotalFare(Rides[] rides) {
		double aggregateFare = 0.0;
		for (Rides ride : rides) {
			aggregateFare += this.calculateTotalFare(ride.getDistance(), ride.getTime());
		}
		return aggregateFare;
	}
}
