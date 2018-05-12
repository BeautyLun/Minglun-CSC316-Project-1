package edu.ncsu.csc316.security_log.util;

import java.util.Date;

import edu.ncsu.csc316.security_log.data.LogEntry;
import edu.ncsu.csc316.security_log.dictionary.ArrayLogList;

/**
 * the merge sort method
 * based on Dr.Jason King's lecture powerPoint
 * https://moodle-courses1718.wolfware.ncsu.edu/course/view.php?id=7153&section=8
 * @author Jason King
 */
public class Sorter {

	/**
	 * sort the list apart
	 * @param array of the original list
	 * @param left index of the list
	 * @param right index of the list
	 * @return a sorted list
	 */
	public static ArrayLogList mergeSort(ArrayLogList array, int left, int right) {
		int size = array.size();
		if (size > 1 && left < right) {
			int mid = (right + left) / 2;
			ArrayLogList l = array.subList(left, mid);
			ArrayLogList r = array.subList(mid + 1, right);
			l = mergeSort(l, 0, l.size() - 1);
			r = mergeSort(r, 0, r.size() - 1);
			array = merge(array, l, r);
		}
		return array;
	}
	
	/**
	 * merge the lists together
	 * @param array of the original list
	 * @param l the left part of the list
	 * @param r the right part of the list
	 * @return the merged list
	 */
	private static ArrayLogList merge(ArrayLogList array, ArrayLogList l, ArrayLogList r) {
		int lIndex = 0;
		int rIndex = 0;
		int size = array.size();
		array = new ArrayLogList(size);
		for (int i = 0; i < size; i++) {
			if (rIndex >= r.size() || (lIndex < l.size() && compare(l.get(lIndex), r.get(rIndex)) <= 0)) {
				array.add(l.get(lIndex));
				lIndex++;
			} else {
				array.add(r.get(rIndex));
				rIndex++;
			}
		}
		return array;
	}
	
	/**
	 * compare two LogEntries
	 * @param first LogEntry
	 * @param second LogEntry
	 * @return the result based on time priority of the LogEntries
	 */
	private static int compare(LogEntry first, LogEntry second) {
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
