/**
 * 
 */
package edu.ncsu.csc316.rentals.graph;

/**
 * the vertex class as well as store the day information
 * @author Minglun Zhang
 * 
 *
 */
public class Vertex {
	
	/** the day */
	private int day;
	/** if found (for Dijkstra¡¯s Algorithm) */
	private boolean found;
	/** weight of the vertex (for Dijkstra¡¯s Algorithm)*/
	private double weight;
	/** the parent of the vertex */
	private Vertex parent;
	/** the edge of the vertex belongs to */
	private Edge edge;
	/** the next vertex */
	private Vertex next;
	
	/**
	 * the constructor
	 * @param day the day
	 * @param found (for Dijkstra¡¯s Algorithm)
	 * @param weight (for Dijkstra¡¯s Algorithm)
	 * @param parent vertex of the vertex
	 * @param edge of the vertex
	 * @param next vertex of the vertex
	 */
	public Vertex(int day, boolean found, double weight, Vertex parent, Edge edge, Vertex next) {
		setNext(next);
		setDay(day);
		setEdge(edge);
		setParent(parent);
		setFound(found);
		setWeight(weight);
	}
	
	/**
	 * return the day of the vertex
	 * @return the day of the vertex
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * set the day of the vertex
	 * @param day of the vertex
	 */
	public void setDay(int day) {
		this.day = day;
	}
	
	/**
	 * return found 
	 * @return found
	 */
	public boolean isFound() {
		return found;
	}
	
	/**
	 * set found
	 * @param found (for Dijkstra¡¯s Algorithm)
	 */
	public void setFound(boolean found) {
		this.found = found;
	}
	
	/**
	 * return the weight
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * set the weight
	 * @param weight (for Dijkstra¡¯s Algorithm)
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	/**
	 * return the parent vertex
	 * @return the parent vertex
	 */
	public Vertex getParent() {
		return parent;
	}
	
	/**
	 * set the parent vertex
	 * @param parent vertex
	 */
	public void setParent(Vertex parent) {
		this.parent = parent;
	}
	
	/**
	 * get the edge
	 * @return the edge
	 */
	public Edge getEdge() {
		return edge;
	}
	
	/**
	 * set the edge
	 * @param edge of the vertex
	 */
	public void setEdge(Edge edge) {
		this.edge = edge;
	}
	
	/**
	 * return the next vertex
	 * @return the next vertex
	 */
	public Vertex getNext() {
		return next;
	}
	
	/**
	 * set the next vertex
	 * @param next vertex
	 */
	public void setNext(Vertex next) {
		this.next = next;
	}
}
