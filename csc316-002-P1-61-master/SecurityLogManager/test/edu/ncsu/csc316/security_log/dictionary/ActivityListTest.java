/**
 * 
 */
package edu.ncsu.csc316.security_log.dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * test file for ActivityList
 * @author Minglun Zhang
 *
 */
public class ActivityListTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.security_log.dictionary.ActivityList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		ActivityList a = new ActivityList();
		assertTrue(a.isEmpty());
		a.add("aaa");
		assertFalse(a.isEmpty());
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.security_log.dictionary.ActivityList#get(int)}.
	 */
	@Test
	public void testGet() {
		ActivityList a = new ActivityList();
		a.add("aaa");
		try {
			a.get(-1);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("aaa", a.get(0).getName());
		}
		
		// reset the ActivityList
		a = new ActivityList();
		a.add("aaa");
		try {
			a.get(1);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("aaa", a.get(0).getName());
		}
	}

}
