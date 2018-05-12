/**
 * 
 */
package edu.ncsu.csc316.security_log.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc316.security_log.data.LogEntry;
import edu.ncsu.csc316.security_log.dictionary.ArrayLogList;

/**
 * the LogEntry IO class
 * @author Minglun Zhang
 *
 */
public class LogEntryReader {
	
	/**
	 * read the file and generalize an ArrayLogList
	 * throw FileNotFoundException if the file cannot be found
	 * @param fileName the path of the file
	 * @return ArrayLogList generalized
	 * @throws FileNotFoundException if the file cannot be found
	 */
    @SuppressWarnings("resource")
	public static ArrayLogList readLogEntry(String fileName) throws FileNotFoundException 
    {
    	ArrayLogList list = new ArrayLogList();
    	Scanner fileReader = new Scanner(new File(fileName));
    	fileReader.nextLine();
    	while (fileReader.hasNextLine()) {
    		try {
    			LogEntry log = readLog(fileReader.nextLine());
    			list.add(log);
    		} catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("fail in reading lines");
            }
    	}
        fileReader.close();
        return list;
    }
    
    /**
     * read every single line of the file
     * @param nextLine a line of the input file
     * @return a LogEntry formed by information on the line
     */
    @SuppressWarnings("resource")
	private static LogEntry readLog(String nextLine) 
    {
    	String name = null;
    	String timeInString = null;
    	String action = null;
    	String resource = null;
    	Date time = null;
    	
    	Scanner lineReader = new Scanner(nextLine);
		lineReader.useDelimiter(", ");
		
		try {
			name = lineReader.next();
			timeInString = lineReader.next();
			action = lineReader.next();
			resource = lineReader.next();
		} catch (NoSuchElementException | IllegalStateException e) {
			throw new IllegalArgumentException("fail in line format");
		}
		lineReader.close();
		
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ssaa", Locale.US);
			time = dateFormat.parse(timeInString);
		} catch (ParseException e) {
			throw new IllegalArgumentException("fail in time parsing");
		}
		return new LogEntry(name, time, action, resource);
    }
}
