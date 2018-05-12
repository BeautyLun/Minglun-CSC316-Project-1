/**
 * 
 */
package edu.ncsu.csc316.hr.util;

/**
 * the array list class
 * 
 * @author Minglun Zhang
 *
 * @param <E> generic type
 */
public class ArrayList<E> {

	/** the initial capacity of the list */
	public static final int INIT_CAP = 5;
	/** the list itself */
	private E[] list;
	/** the current size of the list */
	private int size;
	
	/**
	 * the constructor of the list
	 */
	@SuppressWarnings("unchecked")
	public ArrayList() {
		list = (E[])new Object[INIT_CAP];
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
	@SuppressWarnings("unchecked")
	public void enlargeList() {
		int currentSize = list.length;
		E[] newList = (E[])new Object[currentSize * 2 + 1];
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
	 * add object to the end of the list
	 * @param obj object input
	 */
	public void add(E obj) {
		if (size >= list.length) {
			enlargeList();
		}
		list[size] = obj;
		size++;
	}
	
//	/**
//	 * remove the specific object of the list
//	 * @param obj to be removed
//	 * @return true if removed successful
//	 */
//	public boolean remove(E obj) {
//		for (int i = 0; i < list.length; i++) {
//			if (list[i].equals(obj)) {
//				for (int j = i; j < list.length - 1; j++) {
//					list[j] = list[j + 1];
//				}
//				size--;
//				list[list.length - 1] = null;
//				return true;
//			}
//		}
//		return false;
//	}
	
	/**
	 * remove the first element of the list and return it
	 * @return the first element of the list
	 */
	public E removeFirst() {
		E rtn = list[0];
		for (int i = 0; i < list.length - 1; i++) {
			list[i] = list[i + 1];
		}
		size--;
		list[list.length - 1] = null;
		return rtn;
	}
	
//	public void checkFirst() {
//		if (list[0] == null) {
//			for (int i = 0; i < list.length - 1; i++) {
//				list[i] = list[i + 1];
//			}
//			size--;
//			list[list.length - 1] = null;
//		}
//	}
}
