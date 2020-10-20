package com.capgemini.cabinvoicegenerator;

public class InvoiceSummary {

	private int totalRides;
	private double totalFare;
	private double averageFarePerRide;

	// Initializing to invoice
	public InvoiceSummary(int totalRides, double totalFare) {
		this.totalRides = totalRides;
		this.totalFare = totalFare;
		if (this.totalRides > 0) 
			this.averageFarePerRide = this.totalFare/this.totalRides;
		this.averageFarePerRide = 0;
	}

	// Compare the objects
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(averageFarePerRide);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalFare);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + totalRides;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceSummary other = (InvoiceSummary) obj;
		if (Double.doubleToLongBits(averageFarePerRide) != Double.doubleToLongBits(other.averageFarePerRide))
			return false;
		if (Double.doubleToLongBits(totalFare) != Double.doubleToLongBits(other.totalFare))
			return false;
		if (totalRides != other.totalRides)
			return false;
		return true;
	}
	
	

}
