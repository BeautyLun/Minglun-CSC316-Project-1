package edu.ncsu.csc316.hr.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * test file for arraylist
 * 
 * @author Minglun Zhang
 *
 */
public class ArrayListTest {

	/**
	 * test array list
	 */
	@Test
	public void testArrayList() {
		ArrayList<String> a = new ArrayList<String>();
		assertEquals(0, a.size(), 0);
		assertTrue(a.isEmpty());
		a.add("a");
		a.add("a");
		a.add("a");
		a.add("a");
		a.add("a");
		a.add("a");
		a.add("a");
		a.add("a");
		try {
			a.get(-1);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(a.get(1), "a");
			assertEquals(a.removeFirst(), "a");
		}
	}

}
