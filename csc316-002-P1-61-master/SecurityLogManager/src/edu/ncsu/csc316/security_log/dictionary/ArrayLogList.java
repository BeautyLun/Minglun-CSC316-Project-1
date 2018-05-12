/**
 * 
 */
package edu.ncsu.csc316.security_log.dictionary;

import edu.ncsu.csc316.security_log.data.LogEntry;

/**
 * the list the store LogEntry
 * @author Minglun Zhang
 *
 */
public class ArrayLogList {
	
	/** the initial capacity of the list */
	public static final int INIT_SIZE = 10;
	/** the list itself */
	private LogEntry[] list;
	/** the current size of the list */
	private int size;
	
	/**
	 * the constructor of the list
	 */
	public ArrayLogList() {
		list = new LogEntry[INIT_SIZE];
		this.size = 0;
	}
	
	/**
	 * the constructor of the list
	 * throw IllegalArgumentException if the capacity is not greater than 0
	 * @param idx the capacity of the list
	 * @throws IllegalArgumentException if the capacity is not greater than 0
	 */
	public ArrayLogList(int idx) {
		if (idx <= 0) {
			throw new IllegalArgumentException("capacity needs greater than 0");
		}
		list = new LogEntry[idx];
		this.size = 0;
	}
	
	/**
	 * return the size of the list
	 * @return the size of the list
	 */
	public int size() {
		return size;
	}
	
	/**
	 * check if the list is empty
	 * @return true if is empty
	 * false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * enlarge the list 
	 */
	public void enlargeList() {
		int currentSize = list.length;
		LogEntry[] newList = new LogEntry[currentSize * 2 + 1];
		for (int i = 0; i < currentSize; i++) {
			newList[i] = list[i];
		}
		list = newList;
	}
	
	/**
	 * get the LogEntry based on index
	 * throw IllegalArgumentException if the index is invalid
	 * @param idx index of the list
	 * @return the LogEntry based on index
	 * @throws IllegalArgumentException if the index is invalid
	 */
	public LogEntry get(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IllegalArgumentException();
		}
		return list[idx];
	}
	
	/**
	 * add LogEntry to the end of the list
	 * @param log LogEntry input
	 */
	public void add(LogEntry log) {
		if (size >= list.length) {
			enlargeList();
		}
		list[size] = log;
		size++;
	}
	
	/**
	 * get a sublist of the ArrayLogList
	 * @param left index of the list
	 * @param right index of the list
	 * @return a sublist
	 */
	public ArrayLogList subList(int left, int right) {
		int capacity = right - left + 1;
		if (capacity <= 0) {
			throw new IllegalArgumentException("capacity needs greater than 0");
		}
		ArrayLogList subList = new ArrayLogList(capacity);
		for (int i = left; i <= right; i++) {
			subList.add(this.get(i));
		}
		return subList;
	}
	
//	/**
//	 * self-sorting the list using insertion sort
//	 * based on Dr.Jason King's lecture powerPoint
//	 * https://moodle-courses1718.wolfware.ncsu.edu/course/view.php?id=7153&section=8
//	 * @author Jason King
//	 */
//	public void sort() {
//		for (int i = 1; i < size; i++) {
//			LogEntry temp = list[i];
//			int j = i - 1;
//			while (j >= 0 && compare(list[j], temp) > 0) {
//				list[j + 1] = list[j];
//				j--;
//			}
//			list[j + 1] = temp;
//		}
//	}
//	
//	/**
//	 * the private compare method used to compare two LogEntries
//	 * @param first of the LogEntry
//	 * @param second of the LogEntry
//	 * @return the comparison of two LogEntries
//	 */
//	private int compare(LogEntry first, LogEntry second) {
//		Date date1 = first.getTime();
//		Date date2 = second.getTime();
//		if (date1.equals(date2)) {
//			String name1 = first.getActivity();
//			String name2 = second.getActivity();
//			return name1.compareTo(name2);
//		}
//		return date1.compareTo(date2);
//	}
}
