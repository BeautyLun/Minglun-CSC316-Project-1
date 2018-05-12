/**
 * 
 */
package edu.ncsu.csc316.security_log.data;

import java.util.Date;

/**
 * The LogEntry object
 * @author Minglun Zhang
 *
 */
public class LogEntry {

	/** the name of the user */
	private String name;
	/** the time LogEntry issued */
	private Date time;
	/** the activity user conducted */
	private String activity;
	
	/**
	 * the constructor of the LogEntry
	 * set all the fields
	 * @param name of the user
	 * @param time of the date
	 * @param action of the LogEntry
	 * @param resource of the LogEntry
	 */
	public LogEntry(String name, Date time, String action, String resource) {
		setName(name);
		setTime(time);
		setActivity(action, resource);
	}

	/**
	 * return the name of the LogEntry
	 * @return the name of the LogEntry
	 */
	public String getName() {
		return name;
	}

	/**
	 * return the time of the LogEntry
	 * @return the time of the LogEntry
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * return the activity of the LogEntry
	 * @return the activity of the LogEntry
	 */
	public String getActivity() {
		return activity;
	}

	/**
	 * set the name of the LogEntry
	 * throw Exception if the name is invalid
	 * @param name the name to set
	 * @throws IllegalArgumentException if the name is invalid
	 */
	public void setName(String name) {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException("name invalid");
		}
		this.name = name;
	}

	/**
	 * set the time of the LogEntry
	 * throw Exception if the time is invalid
	 * @param time the time to set
	 * @throws IllegalArgumentException if the time is invalid
	 */
	public void setTime(Date time) {
		if (time == null) {
			throw new IllegalArgumentException("time invalid");
		}
		this.time = time;
	}

	/**
	 * set the activity of the LogEntry
	 * throw Exception if the activity is invalid
	 * @param action of the LogEntry
	 * @param resource of the LogEntry
	 * @throws IllegalArgumentException if the activity is invalid
	 */
	public void setActivity(String action, String resource) {
		if (action == null || action.length() == 0) {
			throw new IllegalArgumentException("action invalid");
		}
		if (resource == null || resource.length() == 0) {
			throw new IllegalArgumentException("resource invalid");
		}
		this.activity = action + " " + resource;
	}
}
