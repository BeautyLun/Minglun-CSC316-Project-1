/**
 * 
 */
package edu.ncsu.csc316.security_log.data;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

/**
 * test file for LogEntry
 * @author Minglun Zhang
 *
 */
public class LogEntryTest {

	/** valid LogEntry fields */
	String name = "Minglun";
	Date time = new Date();
	String action = "read";
	String resource = "books";
	/** initialize a LogEntry */
	LogEntry l = null;
	
	/**
	 * Test method for {@link edu.ncsu.csc316.security_log.data.LogEntry#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		try {
			l = new LogEntry(null, time, action, resource);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(l);
		}
		
		// reset l
		try {
			l = new LogEntry("", time, action, resource);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(l);
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.security_log.data.LogEntry#setTime(java.util.Date)}.
	 */
	@Test
	public void testSetTime() {
		try {
			l = new LogEntry(name, null, action, resource);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(l);
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.security_log.data.LogEntry#setActivity(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSetActivity() {
		try {
			l = new LogEntry(name, time, null, resource);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(l);
		}
		
		// reset l
		l = null;
		try {
			l = new LogEntry(name, time, action, null);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(l);
		}
		
		// reset l
		try {
			l = new LogEntry(name, time, "", resource);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(l);
		}
		
		// reset l
		l = null;
		try {
			l = new LogEntry(name, time, action, "");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(l);
		}
	}

}
