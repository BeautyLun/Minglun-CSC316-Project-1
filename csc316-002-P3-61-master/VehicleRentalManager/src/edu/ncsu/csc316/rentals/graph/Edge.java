/**
 * 
 */
package edu.ncsu.csc316.rentals.graph;

/**
 * the edge class as well as for storing the rental information
 * @author Minglun Zhang
 *
 */
public class Edge {
	
	/** the begin vertex */
	private Vertex begin;
	/** the end vertex */
	private Vertex end;
	/** the cost of the rental */
	private double cost;
	/** the make of the car */
	private String make;
	/** the model of the car */
	private String model;
	
	/**
	 * the constructor 
	 * @param begin vertex
	 * @param end vertex
	 * @param cost of the car
	 * @param make of the car
	 * @param model of the car
	 */
	public Edge(Vertex begin, Vertex end, double cost, String make, String model) {
		setBegin(begin);
		setEnd(end);
		setCost(cost);
		setMake(make);
		setModel(model);
	}
	
	/**
	 * return the begin vertex
	 * @return the begin vertex
	 */
	public Vertex getBegin() {
		return begin;
	}
	
	/**
	 * set the begin vertex
	 * @param begin vertex
	 */
	public void setBegin(Vertex begin) {
		this.begin = begin;
	}
	
	/**
	 * return the end vertex
	 * @return the end vertex
	 */
	public Vertex getEnd() {
		return end;
	}
	
	/**
	 * set the end vertex
	 * @param end vertex
	 */
	public void setEnd(Vertex end) {
		this.end = end;
	}
	
	/**
	 * return the cost of rental
	 * @return the cost of rental
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * set the cost of rental
	 * @param cost of rental
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	/**
	 * return the make of the car
	 * @return the make of the car
	 */
	public String getMake() {
		return make;
	}
	
	/**
	 * set the make of the car
	 * @param make of the car
	 */
	public void setMake(String make) {
		this.make = make;
	}
	
	/**
	 * return the model of the car
	 * @return the model of the car
	 */
	public String getModel() {
		return model;
	}
	
	/**
	 * set the model of the car
	 * @param model of the car
	 */
	public void setModel(String model) {
		this.model = model;
	}
}
