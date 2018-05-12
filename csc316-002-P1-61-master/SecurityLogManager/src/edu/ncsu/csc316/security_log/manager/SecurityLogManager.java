/**
 * 
 */
package edu.ncsu.csc316.security_log.manager;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.ncsu.csc316.security_log.data.Activity;
import edu.ncsu.csc316.security_log.data.LogEntry;
import edu.ncsu.csc316.security_log.dictionary.ActivityList;
import edu.ncsu.csc316.security_log.dictionary.ArrayLogList;
import edu.ncsu.csc316.security_log.io.LogEntryReader;
import edu.ncsu.csc316.security_log.util.Sorter;

/**
 * the SecurityLogManager class
 * @author Minglun Zhang
 *
 */
public class SecurityLogManager {
	
	/** initialize an ArrayLogList */
	private ArrayLogList list;
	
	/**
	 * Constructs a new SecurityLogManager given
	 * the path to the input user activity log file.
	 * 
	 * @param filePath - the path to the user activity log file
	 */
	public SecurityLogManager(String filePath)
	{
		list = new ArrayLogList();
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
		Date startTime = null;
		Date endTime = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ssaa", Locale.US);
			startTime = dateFormat.parse(start);
			endTime = dateFormat.parse(end);
		} catch (ParseException e) {
			throw new IllegalArgumentException("fail in time parsing");
		}
		int count = 0;
		ActivityList l = new ActivityList();
		for (int i = 0; i < list.size(); i++) {
			LogEntry log = list.get(i);
			if (!log.getTime().before(startTime) && !log.getTime().after(endTime)) {
				count++;
				l.add(log.getActivity());
			}
		}
		l.sort();
		StringBuilder sb = new StringBuilder();
		sb.append("OperationalProfile[\r\n");
		for (int i = 0; i < l.size(); i++) {
			Activity a = l.get(i);
			double percentage = (double)a.getFrequency() / (double)count;
			percentage = Double.parseDouble(String.format("%.1f", percentage * 100));
			sb.append("   ");
			sb.append(a.getName());
			sb.append(": frequency: ");
			sb.append(a.getFrequency());
			sb.append(", percentage: ");
			sb.append(Double.toString(percentage));
			sb.append("%\r\n");
		}
		sb.append("]");
		return sb.toString();
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
		ArrayLogList subList = new ArrayLogList();
	    for (int i = 0; i < list.size(); i++) {
	    	LogEntry log = list.get(i);
	    	if (log.getName().equals(username)) {
	    		subList.add(log);
	    	}
	    }
	    StringBuilder sb = new StringBuilder();
	    sb.append("Activity Report for ");
	    sb.append(username);
	    if (subList.isEmpty()) {	
		    sb.append("[\n");
	    	sb.append("   No activity was recorded.\n]");
		    return sb.toString();
	    }
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ssaa", Locale.US);
	    subList = Sorter.mergeSort(subList, 0, subList.size() - 1);
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
