package com.capgemini.cabinvoicegenerator;

public class CabInvoiceGenerator {

	// Constant value for cost
	private static final double COST_PER_KM = 10;
	private static final double COST_PER_MINUTE = 1;
	private static final double MINIMUM_FARE = 5;
	private final RideRepository USER_RIDE_DETAIL;

	public CabInvoiceGenerator() {
		this.USER_RIDE_DETAIL = null;}
	
	// Initializing the user ride detail field
	public CabInvoiceGenerator(String userId, Rides[] rides) {
		USER_RIDE_DETAIL = new RideRepository(userId, rides);
	}

	// Returning total fare
	public double calculateTotalFare(double distance, double time) {
		double totalFare = distance * COST_PER_KM + time * COST_PER_MINUTE;
		return Math.max(totalFare, MINIMUM_FARE);
	}

	// Returning enhanced invoice
	public InvoiceSummary calculateTotalFare(String userId) {
		Rides [] rides = USER_RIDE_DETAIL.getRides(userId);
		double aggregateFare = 0.0;
		for (Rides ride : rides) {
			aggregateFare += this.calculateTotalFare(ride.getDistance(), ride.getTime());
		}
		return new InvoiceSummary(rides.length, aggregateFare);
	}
}
