/**
 * 
 */
package edu.ncsu.csc316.rentals.graph;


import edu.ncsu.csc316.rentals.priority_queue.MinHeap;

/**
 * an adjacencyList to store all input information(vertex and edges)
 * 
 * note:
 * 	the data structure is learned from Dr.Jason King online power point
 * 
 * @author Minglun Zhang
 *
 */
public class AdjacencyList {
	
	/** the initial capacity of the list */
	private static final int INIT_CAP = 2500;
	/** the list itself */
	public Vertex[] list;
	
	/**
	 * the constructor of the list
	 */
	public AdjacencyList() {
		list = new Vertex[INIT_CAP];
	}
	
	/**
	 * get the vertex based on index
	 * throw IllegalArgumentException if the index is invalid
	 * @param idx index of the list
	 * @return the object based on index
	 * @throws IllegalArgumentException if the index is invalid
	 */
	public Vertex get(int idx) {
		if (idx < 0 || idx >= INIT_CAP) {
			throw new IllegalArgumentException();
		}
		return list[idx];
	}
	
	/**
	 * check if the list contains vertex v
	 * @param v vertex
	 * @return true if the vertex exist
	 */
	public boolean contain(Vertex v) {
		return list[v.getDay()] != null;
	}
	
	/**
	 * insert vertex to the list
	 * @param v vertex
	 */
	public void insertVertex(Vertex v) {
		list[v.getDay()] = v;
	}
	
	/**
	 * insert edge after the right vertex
	 * @param e edge
	 */
	public void insertEdge(Edge e) {
		int begin = e.getBegin().getDay();
		Vertex v = null;
		if (list[begin].getNext() == null) {
			v = new Vertex(e.getEnd().getDay(), false, 0, e.getBegin(), e, null);
		} else {
			v = new Vertex(e.getEnd().getDay(), false, 0, e.getBegin(), e, list[begin].getNext());
		}
		list[begin].setNext(v);
	}
	
	/**
	 * get all edges incident to a vertex
	 * @param v the vertex
	 * @return the a list of edges
	 */
	public Edge[] getIncidentEdges(Vertex v) {
		Edge[] edges = new Edge[INIT_CAP];
		int count = 0;
		Vertex temp = list[v.getDay()].getNext();
		while (temp != null) {
			edges[count] = temp.getEdge();
			temp = temp.getNext();
			count++;
		}
		return edges;
	}
	
	/**
	 * get all edges incident to a vertex
	 * sort it with ascending order
	 * note:
	 * 		self-sorting the list using insertion sort
	 *  	based on Dr.Jason King's lecture powerPoint
	 * @param v the vertex
	 * @return the a list of edges
	 */
	public Edge[] getSortedIncidentEdges(Vertex v) {
		Edge[] edges = new Edge[INIT_CAP];
		int count = 0;
		Vertex temp = list[v.getDay()].getNext();
		while (temp != null) {
			edges[count] = temp.getEdge();
			temp = temp.getNext();
			count++;
		}
		
		// sort edges with ascending order
		for (int i = 1; i < count; i++) {
			Edge e = edges[i];
			int j = i - 1;
			while (j >= 0 && compare(edges[j], e) > 0) {
				edges[j + 1] = edges[j];
				j--;
			}
			edges[j + 1] = e;
		}
		return edges;
	}
	
	/**
	 * compare two edges
	 * @param one of the edge
	 * @param two of the edge
	 * @return the the result of compare
	 */
	private double compare(Edge one, Edge two) {
		if (one.getCost() == two.getCost()) {
			if (one.getMake().equals(two.getMake())) {
				return two.getModel().compareTo(one.getModel());
			}
			return two.getMake().compareTo(one.getMake());
		}
		return one.getCost() - two.getCost();
	}
	
	/**
	 * get the opposite vertex of an edge
	 * @param v one vertex of the same edge
	 * @param e the edge
	 * @return the opposite vertex of an edge
	 */
	public Vertex getOpposite(Vertex v, Edge e) {
		Vertex v1 = e.getBegin();
		Vertex v2 = e.getEnd();
		if (v.getDay() == v1.getDay()) {
			return v2;
		} else {
			return v1;
		}
	}
	
	/**
	 * reset the weight, found and parent
	 */
	public void reset() {
		int count = 0;
		while (list[count] != null) {
			list[count].setFound(false);
			list[count].setParent(null);
			list[count].setWeight(0);
		}
	}
	
	/**
	 * find the shortest path started at start
	 * note:
	 * 		this method using Dijkstra¡¯s Algorithm of shortest path
	 * 		learning from Dr.Jason King lecture powerPoint 
	 * @param start pos
	 * @param end pos
	 */
	public void shortestPath(int start, int end) {
		MinHeap heap = new MinHeap();
		int count = start;
		while (list[count] != null) {
			if (count == start) {
				list[count].setWeight(0);
			} else {
				list[count].setWeight(Double.POSITIVE_INFINITY);
			}
			list[count].setParent(null);
			list[count].setFound(false);
			heap.insert(list[count]);
			count++;
		}
		while (heap.size() != 0) {
			Vertex u = heap.deleteMin();
//			if (u.getDay() > end) {
//				break;
//			}
			// update both heap and the list
			u.setFound(true);
			list[u.getDay()].setFound(true);
			count = 0;
			Edge[] edges = this.getIncidentEdges(u);
			while (edges[count] != null) {
				Edge e = edges[count];
				Vertex z = this.getOpposite(u, e);
				double r = e.getCost() + u.getWeight();
				if (r < list[z.getDay()].getWeight()) {
					// update both heap and the list
					z.setWeight(r);
					z.setParent(u);
					list[z.getDay()].setWeight(r);
					list[z.getDay()].setParent(list[u.getDay()]);
					heap.updatePriority(z, r);
					list[z.getDay()].setEdge(e);
				}
				count++;
			}
		}
	}
}
