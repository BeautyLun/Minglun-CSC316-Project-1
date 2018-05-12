package edu.ncsu.csc316.hr.manager;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.hr.io.EmployeeReader;

/**
 * test file for humanResourcesManager
 * 
 * @author Minglun Zhang
 *
 */
public class HumanResourcesManagerTest {

	/**
	 * test generate Oraganizationalprofile
	 */
	@SuppressWarnings("unused")
	@Test
	public void testGenerateOrganizationalProfile() {
		HumanResourcesManager a = new HumanResourcesManager("input/employee.txt", "input/resume.txt");
		String answer = "OrganizationalProfile[\n" + 
				"   Sarah Jones\n" + 
				"   John Smith\n" + 
				"   Jane Doe\n" + 
				"   Suzanne Meadows\n" + 
				"   Thomas Webb\n" + 
				"   Jessica Daniels\n" + 
				"   Kyle DeMarcino\n" + 
				"]";
		assertEquals(answer, a.generateOrganizationalProfile());
		assertNull(a.removeEmployee("a", "a"));
		EmployeeReader er = new EmployeeReader();
	}

}
