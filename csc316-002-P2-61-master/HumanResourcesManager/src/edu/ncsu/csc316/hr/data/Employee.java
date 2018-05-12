/**
 * 
 */
package edu.ncsu.csc316.hr.data;

/**
 * the employee class
 * @author Minglun Zhang
 *
 */
public class Employee {
	
	/** the name of the employee */
	private String name;
	/** the id number of the employee */
	private String id;
	
	/**
	 * the employee constructor
	 * throw exception if input is invalid
	 * @param first name of the employee
	 * @param last name of the employee
	 * @param id of the employee
	 * @throws IllegalArgumentException if input is invalid
	 */
	public Employee(String first, String last, String id) {
		if (first == null || last == null || id == null) {
			throw new IllegalArgumentException("null Employee");
		}
		if (first.equals("") || last.equals("") || id.equals("")) {
			throw new IllegalArgumentException("empty Employee");
		}
		this.name = first + " " + last;
		this.id = id;
	}
	
	/**
	 * return the name of the employee
	 * @return the name of the employee
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * return the id of the employee
	 * @return the id of the employee
	 */
	public String getId() {
		return id;
	}
}
