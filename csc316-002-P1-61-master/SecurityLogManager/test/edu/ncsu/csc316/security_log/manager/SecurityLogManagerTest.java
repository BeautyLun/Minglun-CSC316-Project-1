/**
 * 
 */
package edu.ncsu.csc316.security_log.manager;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.security_log.util.Sorter;


/**
 * test file for security log manager
 * @author Minglun Zhang
 */
public class SecurityLogManagerTest {

	/** valid input file name */
	String valid = "input/activityLog_small.txt";
	/** invalid input file name */
	String invalid = "activityLog_small.txt";
	
	/**
	 * Test method for {@link edu.ncsu.csc316.security_log.manager.SecurityLogManager#SecurityLogManager(java.lang.String)}.
	 */
	@Test
	public void testSecurityLogManager() {
		SecurityLogManager s = null;
		
		// test invalid file input
		try {
			s = new SecurityLogManager(invalid);
			fail();
		} catch(IllegalArgumentException e) {
			assertNull(s);
		}
		
		// reset s
		s = null;
		
		// test valid file input
		try {
			s = new SecurityLogManager(valid);
		} catch(IllegalArgumentException e) {
			fail();
		}
		assertNotNull(s);
		Sorter sorter= new Sorter();
		assertNotNull(sorter);
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.security_log.manager.SecurityLogManager#generateOperationalProfile(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGenerateOperationalProfile() {
		SecurityLogManager s = new SecurityLogManager(valid);
		String result = s.generateOperationalProfile("01/01/2015 00:09:40PM", "10/04/2018 12:17:49PM");
		String answer = "OperationalProfile[\r\n" + 
				"   sort ICD-9 Code 196: frequency: 14, percentage: 87.5%\r\n" +
				"   import office visit OV04312: frequency: 1, percentage: 6.3%\r\n" +
				"   resolve message M2964: frequency: 1, percentage: 6.3%\r\n" +
				"]";
		assertEquals(answer, result);
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.security_log.manager.SecurityLogManager#getUserReport(java.lang.String)}.
	 */
	@Test
	public void testGetUserReport() {
		SecurityLogManager s = new SecurityLogManager(valid);
		String result = s.getUserReport("quhundley");
		String answer = "Activity Report for quhundley[\r\n" + 
				"   07/18/2015 07:57:42PM - sort ICD-9 Code 196\r\n" + 
				"   02/04/2016 08:49:22AM - sort ICD-9 Code 196\r\n" + 
				"   11/20/2016 02:07:54PM - sort ICD-9 Code 196\r\n" + 
				"   08/04/2017 11:01:45AM - sort ICD-9 Code 196\r\n" + 
				"   09/21/2017 08:50:13AM - import office visit OV04312\r\n" + 
				"   11/20/2019 02:07:54PM - drink water\r\n" + 
				"   11/20/2019 02:07:54PM - eat food\r\n" + 
				"]";
		assertEquals(answer, result);
	}

}
