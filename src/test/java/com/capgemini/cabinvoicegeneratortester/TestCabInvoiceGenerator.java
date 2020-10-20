
package com.capgemini.cabinvoicegeneratortester;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.cabinvoicegenerator.CabInvoiceGenerator;
import com.capgemini.cabinvoicegenerator.CabInvoiceGenerator.RideCategory;
import com.capgemini.cabinvoicegenerator.InvoiceSummary;
import com.capgemini.cabinvoicegenerator.Rides;

import java.util.logging.Logger;

public class TestCabInvoiceGenerator {

	public static Logger log = Logger.getLogger(CabInvoiceGenerator.class.getName());
	CabInvoiceGenerator cabInvoiceGenerator = null;

	@Before
	public void setUp() throws Exception {
		cabInvoiceGenerator = new CabInvoiceGenerator();
	}

	// Test for total fare given distance and time
	@Test
	public void givenDistanceAndTimeReturnTotalFare() {
		double distance = 2.0, time = 20.0;
		Assert.assertEquals(40, cabInvoiceGenerator.calculateTotalFare(distance, time, RideCategory.NORMAL_RIDES), 0.0);
		log.info("Total fare returned tested succesfully");
	}

	// Test for minimum fare given distance and time
	@Test
	public void givenDateAndTimeReturnMinimumFare() {
		double distance = 0.2, time = 2;
		Assert.assertEquals(5, cabInvoiceGenerator.calculateTotalFare(distance, time, RideCategory.NORMAL_RIDES), 0.0);
		log.info("Return minimum fare tested successfully");
	}

	// Test for invoice summary for multiple rides based on userId
	@Test
	public void givenMultipleRidesReturnInvoiceSummary() {
		String userId = "Shino";
		Rides[] rides = { new Rides(2.0, 20.0), new Rides(0.2, 2.0) };
		CabInvoiceGenerator cabInvoiceGeneratorParam = new CabInvoiceGenerator(userId, rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 45);
		InvoiceSummary actualInvoiceSummary = cabInvoiceGeneratorParam.calculateTotalFare(userId,
				RideCategory.NORMAL_RIDES);
		Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
		log.info("Return invoice summary for userId tested successfully");
	}

	// Test for total fare given distance and time
	@Test
	public void givenDistanceAndTimeReturnTotalFarePremium() {
		double distance = 2.0, time = 20.0;
		Assert.assertEquals(70, cabInvoiceGenerator.calculateTotalFare(distance, time, RideCategory.PREMIUM_RIDES),
				0.0);
		log.info("Total fare returned tested succesfully");
	}

	// Test for minimum fare given distance and time
	@Test
	public void givenDateAndTimeReturnMinimumFarePremium() {
		double distance = 0.2, time = 2;
		Assert.assertEquals(20, cabInvoiceGenerator.calculateTotalFare(distance, time, RideCategory.PREMIUM_RIDES),0.0);
		log.info("Return minimum fare tested successfully");
	}

	// Test for invoice summary for multiple rides based on userId
	@Test
	public void givenMultipleRidesReturnInvoiceSummaryPremium() {
		String userId = "Shino";
		Rides[] rides = { new Rides(2.0, 20.0), new Rides(0.2, 2.0) };
		CabInvoiceGenerator cabInvoiceGeneratorParam = new CabInvoiceGenerator(userId, rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 90);
		InvoiceSummary actualInvoiceSummary = cabInvoiceGeneratorParam.calculateTotalFare(userId,
				RideCategory.PREMIUM_RIDES);
		Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
		log.info("Return invoice summary for userId tested successfully");
	}
}
