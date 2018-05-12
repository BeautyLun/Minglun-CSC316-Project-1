/**
 * 
 */
package edu.ncsu.csc316.security_log.dictionary;

/**
 * the hash table class
 * @param <E> general type
 * @author Minglun Zhang
 *
 */
public class HashTable<E> {
	
	/** the load factor */
	public static final double LOAD_FACTOR = 0.75;
	/** the initial capacity of the table */
	public static final int INIT_CAP = 10;
	/** the initial list */
	private Object[] list;
	/** the current size of the list */
	private int size;
	
	/**
	 * Constructs a new generic HashTable with
	 * some initial default capacity
	 */
	public HashTable()
	{
	    this.size = 0;
	    list = new Object[INIT_CAP];
	    for (int i = 0; i < INIT_CAP; i++) {
	    	list[i] = new ArrayBasedList<E>();
	    }
	}
	
	/** 
	 * re-size the hash table
	 */
	@SuppressWarnings("unchecked")
	private void growTable() {
		// create a new list
		Object[] newlist = new Object[2 * list.length];
		for (int i = 0; i < newlist.length; i++) {
			newlist[i] = new ArrayBasedList<E>();
	    }
		for (int i = 0; i < list.length; i++) {
			ArrayBasedList<E> castList = (ArrayBasedList<E>)list[i];
			if (castList.size() != 0) {
				for (int j = 0; j < castList.size(); j++) {
					E value = castList.get(j);
					int idx = Math.abs(value.hashCode() % newlist.length);
					ArrayBasedList<E> castNewList = (ArrayBasedList<E>)newlist[idx];
				    castNewList.add(value);
				}
			}
		}
		list = newlist;
	}
	
	/**
	 * Inserts the generic value E into the hash table
	 *
	 * @param value - the value to insert into the hash table
	 */
	@SuppressWarnings("unchecked")
	public void insert(E value)
	{
	    if (((double)size / (double)list.length) > LOAD_FACTOR) {
	    	growTable();
	    }
	    int idx = Math.abs(value.hashCode() % list.length);
	    ArrayBasedList<E> castList = (ArrayBasedList<E>)list[idx];
	    castList.add(value);
	    size++;
	}
	
	/**
	 * Finds the value E in
	 * the hash table. Returns the value E
	 * if the value was found in the hash table.
	 * If the value is not in the hash table, return null.
	 *
	 * @param value - the value to search for in the hash table
	 * @return the reference to the value in the hash table, or null if the value 
	 *              is not in the hash table
	 */
	@SuppressWarnings("unchecked")
	public E lookUp(E value)
	{
		int idx = Math.abs(value.hashCode() % list.length);
		ArrayBasedList<E> castList = (ArrayBasedList<E>)list[idx];
		for (int i = 0; i < castList.size(); i++) {
			if (castList.get(i).equals(value)) {
				return value;
			}
		}
		return null;
	}
	
	/**
	 * Returns the number of values in the hash table
	 * 
	 * @return the number of values in the hash table
	 */
	public int size()
	{
	    return size;
	}
	
	/**
	 * Returns the length/capacity of the hash table
	 * 
	 * @return the length/capacity of the hash table
	 */
	public int getHashTableLength()
	{
	    return list.length;
	}
}
