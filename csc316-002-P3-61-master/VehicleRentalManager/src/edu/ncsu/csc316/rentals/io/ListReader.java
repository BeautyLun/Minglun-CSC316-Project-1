/**
 * 
 */
package edu.ncsu.csc316.rentals.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc316.rentals.graph.AdjacencyList;
import edu.ncsu.csc316.rentals.graph.Edge;
import edu.ncsu.csc316.rentals.graph.Vertex;



/**
 * the reader io class
 * @author Minglun Zhang
 *
 */
public class ListReader {

	/**
	 * read the file and generalize an list
	 * throw FileNotFoundException if the file cannot be found
	 * @param fileName the path of the file
	 * @return list generalized
	 * @throws FileNotFoundException if the file cannot be found
	 */
    @SuppressWarnings("resource")
	public static AdjacencyList readRental(String fileName) throws FileNotFoundException 
    {
    	AdjacencyList list = new AdjacencyList();
    	Scanner fileReader = new Scanner(new File(fileName));
    	fileReader.nextLine();
    	while (fileReader.hasNextLine()) {
    		try {
    			Edge e = readEdge(fileReader.nextLine());
    			if (!list.contain(e.getBegin())) {
    				list.insertVertex(e.getBegin());
    			}
    			if (!list.contain(e.getEnd())) {
    				list.insertVertex(e.getEnd());
    			}
    			list.insertEdge(e);
    		} catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("fail in reading lines");
            }
    	}
        fileReader.close();
        return list;
    }

    /**
     * read the edge from the line
     * @param nextLine of the input
     * @return an edge
     */
	@SuppressWarnings("resource")
	private static Edge readEdge(String nextLine) {
		int begin = 0;
		int end = 0;
		int cost = 0;
		String make = null;
		String model = null;
		Scanner lineReader = new Scanner(nextLine);
		lineReader.useDelimiter(",");
		
		try {
			begin = lineReader.nextInt();
			end = lineReader.nextInt();
			cost = lineReader.nextInt();
			make = lineReader.next();
			model = lineReader.next();
		} catch (NoSuchElementException | IllegalStateException e) {
			throw new IllegalArgumentException("fail in line format");
		}
		lineReader.close();
		Vertex v1 = new Vertex(begin, false, 0, null, null, null);
		Vertex v2 = new Vertex(end, false, 0, null, null, null);
		Edge e = new Edge(v1, v2, cost, make, model);
		return e;
	}
}
