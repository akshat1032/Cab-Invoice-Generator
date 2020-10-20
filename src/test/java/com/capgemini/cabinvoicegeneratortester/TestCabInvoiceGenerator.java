
package com.capgemini.cabinvoicegeneratortester;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.cabinvoicegenerator.CabInvoiceGenerator;

import java.util.logging.Logger;

public class TestCabInvoiceGenerator {

	public static Logger log = Logger.getLogger(CabInvoiceGenerator.class.getName());

	@Test
	public void givenDistanceAndTimeReturnTotalFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		double distance = 2.0, time = 20.0;
		Assert.assertEquals(40, cabInvoiceGenerator.calculateTotalFare(distance, time), 0.0);
		log.info("Total fare returned tested succesfully");
	}

	@Test
	public void givenDateAndTimeReturnMinimumFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		double distance = 0.2, time = 2;
		Assert.assertEquals(5, cabInvoiceGenerator.calculateTotalFare(distance, time), 0.0);
		log.info("Return minimum fare tested successfully");
	}
}
