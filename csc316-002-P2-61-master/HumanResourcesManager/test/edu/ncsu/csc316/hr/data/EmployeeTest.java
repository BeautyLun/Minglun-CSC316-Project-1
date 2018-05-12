package edu.ncsu.csc316.hr.data;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * test file for employee
 * 
 * @author Minglun Zhang
 *
 */
public class EmployeeTest {

	/**
	 * test employee
	 */
	@Test
	public void testEmployee() {
		Employee a = null;
		try {
			a = new Employee(null, "a", "a");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(a);
		}
		
		try {
			a = new Employee("", "a", "a");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(a);
		}
		
		try {
			a = new Employee("a", null, "a");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(a);
		}
		
		try {
			a = new Employee("a", "", "a");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(a);
		}
		
		try {
			a = new Employee("a", "a", null);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(a);
		}
		
		try {
			a = new Employee("a", "a", "");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(a);
		}
		
		a = new Employee("a", "a", "a");
		assertEquals("a", a.getId());
	}
}
