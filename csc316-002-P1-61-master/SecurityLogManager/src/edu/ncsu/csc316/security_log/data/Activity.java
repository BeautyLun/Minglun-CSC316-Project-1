/**
 * 
 */
package edu.ncsu.csc316.security_log.data;

/**
 * The Activity object
 * @author Minglun Zhang
 *
 */
public class Activity {
	
	/** the name of the activity */
	private String name;
	/** the frequency of the activity in given time */
	private int frequency;
	
	/**
	 * the constructor
	 * @param name of the activity
	 */
	public Activity(String name) {
		setName(name);
		frequency = 1;
	}

	/**
	 * return the name of the activity
	 * @return the name of the activity
	 */
	public String getName() {
		return name;
	}

	/**
	 * set the name of the activity
	 * @param name of the activity
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * return the frequency of the activity
	 * @return the frequency of the activity
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * add frequency
	 */
	public void addFrequency() {
		frequency++;
	}
}
