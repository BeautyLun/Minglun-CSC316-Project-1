/**
 * 
 */
package edu.ncsu.csc316.security_log.dictionary;

import edu.ncsu.csc316.security_log.data.Activity;

/**
 * the list to store activities
 * @author Minglun Zhang
 *
 */
public class ActivityList {
	
	/** the initial capacity of the list */
	public static final int INIT_SIZE = 1;
	/** the list itself */
	private Activity[] list;
	/** the current size of the list */
	private int size;
	
	/**
	 * the constructor of the list
	 */
	public ActivityList() {
		list = new Activity[INIT_SIZE];
		this.size = 0;
	}
	
	/**
	 * the size of the List
	 * @return the size of the list
	 */
	public int size() {
		return size;
	}
	
	/**
	 * check if the list is empty
	 * return true if the list is empty
	 * false otherwise
	 * @return true if the list is empty
	 * 		false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * enlarge the list with a new capacity
	 */
	public void enlargeList() {
		int currentSize = list.length;
		Activity[] newList = new Activity[currentSize * 2 + 1];
		for (int i = 0; i < currentSize; i++) {
			newList[i] = list[i];
		}
		list = newList;
	}
	
	/**
	 * return the activity based on the index
	 * throw IllegalArgumentException if the index is invalid
	 * @param idx of the list
	 * @return the activity based on the index
	 * @throws IllegalArgumentException if the index is invalid
	 */
	public Activity get(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IllegalArgumentException();
		}
		return list[idx];
	}
	
	/**
	 * add an activity to the list based on given name
	 * @param name of the activity
	 */
	public void add(String name) {
		if (size >= list.length) {
			enlargeList();
		}
		for (int i = 0; i < size; i++) {
			if (name.equals(list[i].getName())) {
				list[i].addFrequency();
				return;
			}
		}
		list[size] = new Activity(name);
		size++;
	}
	
	/**
	 * self-sorting the list using insertion sort
	 * based on Dr.Jason King's lecture powerPoint
	 * https://moodle-courses1718.wolfware.ncsu.edu/course/view.php?id=7153&section=8
	 * @author Jason King
	 */
	public void sort() {
		for (int i = 1; i < size; i++) {
			Activity temp = list[i];
			int j = i - 1;
			while (j >= 0 && compare(list[j], temp) < 0) {
				list[j + 1] = list[j];
				j--;
			}
			list[j + 1] = temp;
		}
	}
	
	/**
	 * the private compare method used to compare two activities
	 * @param one of the activity
	 * @param two of the activity
	 * @return the comparison of the frequency of two activities
	 */
	private int compare(Activity one, Activity two) {
		int f1 = one.getFrequency();
		int f2 = two.getFrequency();
		if (f1 == f2) {
			return two.getName().compareTo(one.getName());
		} 
		return f1 - f2;
	}
}
