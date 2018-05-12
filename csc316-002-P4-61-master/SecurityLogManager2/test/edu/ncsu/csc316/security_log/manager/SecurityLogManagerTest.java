package edu.ncsu.csc316.security_log.manager;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.security_log.io.LogEntryReader;

/**
 * the test file for manager
 * 
 * @author Minglun Zhang
 *
 */
public class SecurityLogManagerTest {

	/** valid input file name */
	String valid = "input/small.txt";
	/** invalid input file name */
	String invalid = "activityLog_small.txt";
	
	/**
	 * the test itself
	 */
	@Test
	public void test() {
		SecurityLogManager s = new SecurityLogManager(valid);
		@SuppressWarnings("unused")
		LogEntryReader l = new LogEntryReader();
		assertEquals(s.generateOperationalProfile("a", "b"), "a");
//		assertEquals(s.getUserReport("aaa"), "aaa");
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
				"]";
		assertEquals(answer, result);
	}

}
