/**
 * 
 */
package edu.ncsu.csc316.rentals.priority_queue;

import edu.ncsu.csc316.rentals.graph.Vertex;

/**
 * a vertex minimum heap to get shortest path using Dijkstra¡¯s Algorithm
 * 
 * note:
 * 	the data structure is learned from Dr.Jason King online power point
 * 
 * @author Minglun Zhang
 *
 */
public class MinHeap {
	
	/** the cap of the heap */
	private static final int CAP = 2500;
	/** the heap data structure */
	private Vertex[] heap;
	/** the size of the heap */
	private int size;
	
	/**
	 * the constructor
	 */
	public MinHeap() {
		this.heap = new Vertex[CAP];
		this.size = 0;
	}
	
	/**
	 * the size of the heap
	 * @return the size of the heap
	 */
	public int size() {
		return size;
	}
	
	/**
	 * insert a new vertex to the list
	 * up heap then
	 * @param v vertex
	 */
	public void insert(Vertex v) {
		heap[size] = v;
		upHeap(size);
		size++;
	}
	
	/**
	 * compare the vertex with his parents
	 * swap if necessary 
	 * @param pos of the vertex
	 */
	private void upHeap(int pos) {
		if (pos > 0 && heap[pos].getWeight() < heap[(pos - 1) / 2].getWeight()) {
			swap(pos, (pos - 1) / 2);
			upHeap((pos - 1) / 2);
		}
	}
	
	/**
	 * swap the positions of two vertex
	 * @param pos1 of one
	 * @param pos2 of another
	 */
	private void swap(int pos1, int pos2) {
		Vertex temp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = temp;
	}
	
	/**
	 * remove the minimum vertex
	 * swap the last to there
	 * down heap if necessary
	 * @return the first vertex
	 */
	public Vertex deleteMin() {
		Vertex rtn = heap[0];
		size--;
		swap(0, size);
		downHeap(0);
		return rtn;
	}
	
	/**
	 * compare the vertex with his children
	 * @param pos of the vertex
	 */
	private void downHeap(int pos) {
		// i is m's smallest child, if one exists
		int i = 0;
		// if both children exist
		if (2 * (pos + 1) < size) {
			if (heap[2 * (pos + 1)].getWeight() <= heap[2 * pos + 1].getWeight()) {
				i = 2 * (pos + 1);
			} else {
				i = 2 * pos + 1;
			}
		} else if (2 * pos + 1 < size) {
			i = 2 * pos + 1;
		}
		// at this stage, if i = 0, then the node has no children
		if (i > 0 && heap[pos].getWeight() > heap[i].getWeight()) {
			swap(pos, i);
			downHeap(i);
		}	
	}
	
	/**
	 * change the weight of the vertex
	 * update the heap 
	 * @param v of the vertex
	 * @param weight of the target weight
	 */
	public void updatePriority(Vertex v, double weight) {
		for (int i = 0; i < size; i++) {
			// find the vertex
			if (heap[i].getDay() == v.getDay()) {
				// change the weight
				double temp = heap[i].getWeight();
				heap[i].setWeight(weight);
				// re-order the list, based on weight
				if (weight > temp) {
					downHeap(i);
				} else {
					upHeap(i);
				}
				// terminate the loop
				break;
			}
		}
	}
}
