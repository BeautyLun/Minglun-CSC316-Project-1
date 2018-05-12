package edu.ncsu.csc316.security_log.dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * the array based list test
 * 
 * @author Minglun Zhang
 *
 */
public class ArrayBasedListTest {

	/**
	 * the test itself
	 */
	@Test
	public void test() {
		ArrayBasedList<String> l = new ArrayBasedList<String>();
		l.add("a");
		l.add("aw");
		l.add("ae");
		l.add("ar");
		l.add("at");
		l.add("ay");
		l.add("au");
		l.add("ai");
		l.add("aofd");
		l.add("assg");
		l.add("agds");
		l.add("adf");
		l.add("sdfa");
		l.add("asdffgg");
		l.add("adg");
		l.add("dfgha");
		assertTrue(l.size() == 16);
		assertEquals(l.get(0), "a");
		assertTrue(l.capacity() == 20);
	}
}
