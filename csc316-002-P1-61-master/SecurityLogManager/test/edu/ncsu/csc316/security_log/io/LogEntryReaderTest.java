/**
 * 
 */
package edu.ncsu.csc316.security_log.io;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * the test file for the LogEntryReader
 * @author Minglun Zhang
 *
 */
public class LogEntryReaderTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.security_log.io.LogEntryReader#readLogEntry(java.lang.String)}.
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testReadLogEntry() {
		LogEntryReader l = new LogEntryReader();
		try {
			l.readLogEntry("input-invalid.txt");
			fail();
		} catch (Exception e) {
			assertNotNull(l);
		}
		
		try {
			l.readLogEntry("input-invalid2.txt");
			fail();
		} catch (Exception e) {
			assertNotNull(l);
		}
	}

}
