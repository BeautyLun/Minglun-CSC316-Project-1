/**
 * 
 */
package edu.ncsu.csc316.security_log.data;

import java.util.Date;

/**
 * the log entry object
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
		
		this.name = name;
	}

	/**
	 * set the time of the LogEntry
	 * throw Exception if the time is invalid
	 * @param time the time to set
	 * @throws IllegalArgumentException if the time is invalid
	 */
	public void setTime(Date time) {
		
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
		
		this.activity = action + " " + resource;
	}

//	/**
//	 * @see java.lang.Object#hashCode()
//	 */
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((activity == null) ? 0 : activity.hashCode());
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + ((time == null) ? 0 : time.hashCode());
//		return result;
//	}
//
//	/**
//	 * @see java.lang.Object#equals(java.lang.Object)
//	 */
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		LogEntry other = (LogEntry) obj;
//		if (activity == null) {
//			if (other.activity != null)
//				return false;
//		} else if (!activity.equals(other.activity))
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (time == null) {
//			if (other.time != null)
//				return false;
//		} else if (!time.equals(other.time))
//			return false;
//		return true;
//	}
}
