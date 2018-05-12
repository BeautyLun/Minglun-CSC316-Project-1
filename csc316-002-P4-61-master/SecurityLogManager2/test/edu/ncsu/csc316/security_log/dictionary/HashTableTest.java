/**
 * 
 */
package edu.ncsu.csc316.security_log.dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * the test file for hash table
 * @author Minglun Zhang
 *
 */
public class HashTableTest {

	/**
	 * the test itself
	 */
	@Test
	public void test() {
		HashTable<String> h = new HashTable<String>();
		h.insert("a");
		h.insert("b");
		h.insert("c");
		h.insert("d");
		h.insert("e");
		h.insert("f");
		h.insert("g");
		h.insert("h");
		h.insert("i");
		h.insert("j");
		h.insert("k");
		h.insert("l");
		h.insert("m");
		h.insert("n");
		assertEquals(h.lookUp("a"), "a");
		assertNull(h.lookUp("z"));
		assertFalse(h.size() == 0);
		assertTrue(h.getHashTableLength() != 0);
	}
}
