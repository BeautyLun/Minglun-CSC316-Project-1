/**
 * 
 */
package edu.ncsu.csc316.rentals.manager;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.rentals.io.ListReader;

/**
 * the test file for the project
 * @author Minglun Zhang
 *
 */
public class VehicleRentalManagerTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.rentals.manager.VehicleRentalManager#VehicleRentalManager(java.lang.String)}. 
	 */
	@SuppressWarnings("unused")
	@Test
	public void testVehicleRentalManager() {
		VehicleRentalManager v = new VehicleRentalManager("input/333.txt");
		String output = v.getRentals(1, 5);
		assertEquals(output, "Rental total is $175.00\n" + 
				"[\n" + 
				"   From day 1 to day 2: $85.00, Chevrolet Tahoe\n" + 
				"   From day 2 to day 4: $90.00, Jeep Cherokee\n" + 
				"   No rentals available on day 4\n" + 
				"]");
		
		v = new VehicleRentalManager("input/222.txt");
		output = v.getRentals(1, 5);
		assertEquals(output, "Rental total is $225.00\n" + 
				"[\n" + 
				"   From day 1 to day 2: $85.00, Chevrolet Tahoe\n" + 
				"   From day 2 to day 4: $90.00, Jeep Cherokee\n" + 
				"   From day 4 to day 5: $50.00, Honda Accord\n" + 
				"]");
		
		v = new VehicleRentalManager("input/111.txt");
		output = v.getRentalsForDay(1);
		assertEquals(output, "Available rentals for day 1\n" + 
				"   $85.00 Chevrolet Tahoe for day 1 to day 2\n" + 
				"   $180.00 Chevrolet Silverado for day 1 to day 3\n" + 
				"   $255.00 Toyota Prius for day 1 to day 4\n" + 
				"   $500.00 Honda CRV for day 1 to day 5\n" + 
				"]");
		
		ListReader l = new ListReader();
	}

}
