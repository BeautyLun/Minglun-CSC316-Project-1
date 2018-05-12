/**
 * 
 */
package edu.ncsu.csc316.hr.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc316.hr.data.Employee;
import edu.ncsu.csc316.hr.tree.EmployeeNode;

/**
 * the employee io class
 * @author Minglun Zhang
 *
 */
public class EmployeeReader {
	
	/**
	 * read the file and generalize the employee list
	 * throw FileNotFoundException if the file cannot be found
	 * @param fileName the path of the file
	 * @return employee list generalized
	 * @throws FileNotFoundException if the file cannot be found
	 */
	public static EmployeeNode readEmployee(String fileName) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new File(fileName));
		EmployeeNode root = null;
		if (fileReader.hasNextLine()) {
			root = readNode(fileReader.nextLine());
		}
		while (fileReader.hasNextLine()) {
			String line = fileReader.nextLine();
			if (line.contains("(")) {
				root.addChild(readNode(fileReader.nextLine()).getData());
				root = root.getChildren().get(0);
			} else if (line.contains(")")) {
				root = root.getParent();
			} else if (!(line == null || line.equals(" ") || line.equals(""))){
				root.getParent().addChild(readNode(line).getData()); 
			}
		}
        fileReader.close();
        return root;
	}
	
	/**
	 * read every single line of the file
	 * @param line a line of the input file
	 * @return a employeeNode
	 */
	@SuppressWarnings("resource")
	private static EmployeeNode readNode(String line) {
		Employee employee = null;
		String first = null;
		String last = null;
		String id = null;
		Scanner lineReader = new Scanner(line);
		lineReader.useDelimiter(",");
		try {
			first = lineReader.next();
			last = lineReader.next();
			id = lineReader.next();
			first = first.replaceAll(" ", "");
		} catch(NoSuchElementException | IllegalStateException e) {
			throw new IllegalArgumentException("fail in reading line");
		}
		lineReader.close();
		employee = new Employee(first, last, id);
		return new EmployeeNode(employee);
	}	
}
