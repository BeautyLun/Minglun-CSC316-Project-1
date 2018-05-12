package edu.ncsu.csc316.security_log.manager;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import edu.ncsu.csc316.security_log.data.LogEntry;
import edu.ncsu.csc316.security_log.dictionary.ArrayBasedList;
import edu.ncsu.csc316.security_log.io.LogEntryReader;

/**
 * 
 * the security log manager class
 * @author Minglun Zhang
 *
 */
public class SecurityLogManager {
	
	/** initialize an ArrayLogList */
	private ArrayBasedList<LogEntry> list;
	
	/**
	 * Constructs a new SecurityLogManager given
	 * the path to the input user activity log file.
	 * 
	 * @param filePath - the path to the user activity log file
	 */
	public SecurityLogManager(String filePath)
	{
		list = new ArrayBasedList<LogEntry>();
		try {
			list = LogEntryReader.readLogEntry(filePath);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Cannot find file.");
		}
	}

	/**
	 * Produces an operational profile of user activity
	 * performed between the given start and end dates (inclusive)
	 * 
	 * @param start - the start date in the format "MM/DD/YYYY HH:MM:SSXM"
	 * @param end - the end date in the format "MM/DD/YYYY HH:MM:SSXM"
	 * @return a string representing the operational profile
	 */
	public String generateOperationalProfile(String start, String end)
	{
	    return start;
	}
	
	/**
	 * Produces a list of log entries for a given 
	 * user. The output list is sorted chronologically.
	 * 
	 * @param username - the user for which to generate a report
	 * @return a string representing the user report
	 */
	public String getUserReport(String username)
	{
		ArrayBasedList<LogEntry> subList = new ArrayBasedList<LogEntry>();
		for (int i = 0; i < list.size(); i++) {
	    	LogEntry log = list.get(i);
	    	if (log.getName().equals(username)) {
	    		subList.add(log);
	    	}
	    }
		StringBuilder sb = new StringBuilder();
	    sb.append("Activity Report for ");
	    sb.append(username);
	    if (subList.size() == 0) {	
		    sb.append("[\n");
	    	sb.append("   No activity was recorded.\n]");
		    return sb.toString();
	    }
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ssaa", Locale.US);
	    subList.sort();
	    sb.append("[\r\n");
	    for (int i = 0; i < subList.size(); i++) {
	    	sb.append("   ");
	    	sb.append(dateFormat.format(subList.get(i).getTime()));
	    	sb.append(" - ");
	    	sb.append(subList.get(i).getActivity());
	    	sb.append("\r\n");
	    }
	    sb.append("]");
	    return sb.toString();
	}
}
