/**
 * 
 */
package edu.ncsu.csc316.security_log.dictionary;

import java.util.Date;

import edu.ncsu.csc316.security_log.data.LogEntry;

/**
 * the array based list
 * @param <E> general type
 * @author Minglun Zhang
 *
 */
public class ArrayBasedList<E> {
	
	/** the initial capacity of the list */
	public static final int INIT_CAP = 10;
	/** the list itself */
	public E[] list;
	/** the current size of the list */
	private int size;
	
	/**
	 * the constructor
	 */
	@SuppressWarnings("unchecked")
	public ArrayBasedList() {
		this.size = 0;
		list = (E[]) (new Object[INIT_CAP]);
	}
	
	/**
	 * return the size of the list
	 * @return the size of the list
	 */
	public int size() {
		return size;
	}
	
	/**
	 * return current capacity
	 * @return current capacity
	 */
	public int capacity() {
		return list.length;
	}
	
	@SuppressWarnings("unchecked")
	private void growSize() {
		int currentSize = list.length;
		E[] newList = (E[]) (new Object[currentSize * 2]);
		for (int i = 0; i < currentSize; i++) {
			newList[i] = list[i];
		}
		list = newList;
	}
	
	/**
	 * get the object based on index
	 * throw IllegalArgumentException if the index is invalid
	 * @param idx index of the list
	 * @return the object based on index
	 * @throws IllegalArgumentException if the index is invalid
	 */
	public E get(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IllegalArgumentException();
		}
		return list[idx];
	}
	
	/**
	 * add LogEntry to the end of the list
	 * @param ele LogEntry input
	 */
	public void add(E ele) {
		if (size >= list.length) {
			growSize();
		}
		list[size] = ele;
		size++;
	}
	
	/**
	 * ONLY FOR SORTING LOGENTRY!!!
	 * 
	 * 
	 * self-sorting the list using insertion sort
	 * based on Dr.Jason King's lecture powerPoint
	 * https://moodle-courses1718.wolfware.ncsu.edu/course/view.php?id=7153&section=8
	 * @author Jason King
	 */
	@SuppressWarnings("unchecked")
	public void sort() {
		for (int i = 1; i < size; i++) {
			LogEntry temp = (LogEntry)list[i];
			int j = i - 1;
			while (j >= 0 && compare((LogEntry)list[j], temp) > 0) {
				list[j + 1] = list[j];
				j--;
			}
			list[j + 1] = (E) temp;
		}
	}
	
	/**
	 * ONLY FOR SORTING LOGENTRY!!!
	 * 
	 * 
	 * the private compare method used to compare two LogEntries
	 * @param first of the LogEntry
	 * @param second of the LogEntry
	 * @return the comparison of two LogEntries
	 */
	private int compare(LogEntry first, LogEntry second) {
		Date date1 = first.getTime();
		Date date2 = second.getTime();
		if (date1.equals(date2)) {
			String name1 = first.getActivity();
			String name2 = second.getActivity();
			return name1.compareTo(name2);
		}
		return date1.compareTo(date2);
	}
}
