/**
 * 
 */
package edu.ncsu.csc316.security_log.dictionary;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import edu.ncsu.csc316.security_log.data.LogEntry;

/**
 * test file for ArrayLogList
 * @author Minglun Zhang
 *
 */
public class ArrayLogListTest {

	/** initialize a ArrayLogList */
	ArrayLogList l = null;
	
	/**
	 * Test method for {@link edu.ncsu.csc316.security_log.dictionary.ArrayLogList#ArrayLogList()}.
	 */
	@Test
	public void testArrayLogList() {
		try {
			l = new ArrayLogList(-1);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(l);
		}
		
		// reset the ArrayLogList
		l = new ArrayLogList();
		assertTrue(l.isEmpty());
		l.add(new LogEntry("name", new Date(), "play", "games"));
		assertFalse(l.isEmpty());
		
		// test negative get index
		try {
			l.get(-1);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("name", l.get(0).getName());
		}
		
		// test get index out of bound
		try {
			l.get(2);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("name", l.get(0).getName());
		}
		
		try {
			l.subList(5, 3);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("name", l.subList(0, 0).get(0).getName());
		}
	}

}
