/**
 * 
 */
package edu.ncsu.csc316.rentals.manager;

import java.io.FileNotFoundException;

import edu.ncsu.csc316.rentals.graph.AdjacencyList;
import edu.ncsu.csc316.rentals.graph.Edge;
import edu.ncsu.csc316.rentals.graph.Vertex;
import edu.ncsu.csc316.rentals.io.ListReader;

/**
 * the vehicle rental manager class
 * 
 * note:
 * 		for the classes or methods that are not my own work, i have cited at the front of each
 * 
 * @author Minglun Zhang
 *
 */
public class VehicleRentalManager {
	
	/** initialize an list */
	private AdjacencyList list;
	
	/**
	 * Constructs a new Rental manager with the given input files
	 * 
	 * @param pathToFile
	 *            - the path to the employee input file
	 */
	public VehicleRentalManager(String pathToFile) {
	    list = new AdjacencyList();
	    try {
	    	list = ListReader.readRental(pathToFile);
	    } catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Cannot find file.");
		}
	}
	
	/**
	 * Returns the String representation of the rentals that
	 * minimize the total cost from the start day to the end day
	 * (or for as many days from the start day while rentals are possible).
	 * 
	 * @param start - the start day as an integer
	 * @param end - the end day as an integer
	 * @return the String representation of the rentals
	 */
	public String getRentals(int start, int end) {
		// set the found, parent, weight to initial value
		list.reset();
		// execute the Dijkstra¡¯s Algorithm
		list.shortestPath(start, end);
		// to find if all days are connect
		int actualEnd = end;
		while (list.get(actualEnd) == null || !list.get(actualEnd).isFound()) {
			actualEnd--;
		}
		// build the output
		StringBuilder sb = new StringBuilder();
		Vertex result = list.get(actualEnd);
		sb.append("Rental total is $" + result.getWeight() + "0\n[\n");
		// the list of edges of the shortest path
		Edge[] sub = new Edge[actualEnd - start];
		int size = 0;
		while ( result.getParent() != null){
			sub[size] = result.getEdge();
			size++;
			result = result.getParent();
		}
		for( int i = size - 1; i >= 0; i--) {
			sb.append("   From day " + sub[i].getBegin().getDay() + " to day ");
			sb.append(sub[i].getEnd().getDay() + ": $" + sub[i].getCost() + "0, ");
			sb.append(sub[i].getMake() + " " + sub[i].getModel() + "\n");
		}
		if (actualEnd != end) {
			sb.append("   No rentals available on day " + sub[0].getEnd().getDay() + "\n");
		}
		sb.append("]");
		return sb.toString();
	}
	
	/**
	 * Returns the String representation of the rentals 
	 * that are available for the requested day. 
	 * 
	 * @param day - the day for which to retrieve available rentals
	 * @return the String representation of the rentals
	 */
	public String getRentalsForDay(int day) {
		// get the sorted edges with ascending cost and further restrictions
		Edge[] edges = list.getSortedIncidentEdges(list.get(day));
		StringBuilder sb = new StringBuilder();
		// start building the output
		sb.append("Available rentals for day " + day + "\n");
		if (edges[0] == null) {
			sb.append("   No rentals available.\n]");
			return sb.toString();
		}
		for (int i = 0; i < edges.length; i++) {
			if( edges[i] == null ){
				break;
			}
			sb.append("   $" + edges[i].getCost() + "0 " + edges[i].getMake());
			sb.append(" " + edges[i].getModel() + " for day " + day + " to day ");
			sb.append(edges[i].getEnd().getDay() + "\n");
		}
		sb.append("]");
		return sb.toString();
	}
}
