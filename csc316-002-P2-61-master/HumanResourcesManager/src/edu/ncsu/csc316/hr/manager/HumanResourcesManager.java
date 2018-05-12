/**
 * 
 */
package edu.ncsu.csc316.hr.manager;

import java.io.FileNotFoundException;

import edu.ncsu.csc316.hr.io.EmployeeReader;
import edu.ncsu.csc316.hr.tree.EmployeeNode;
import edu.ncsu.csc316.hr.util.ArrayList;

/**
 * the HumanResourcesManager class
 * @author Minglun Zhang
 *
 */
public class HumanResourcesManager {
	
	/** initialize the employee root */
	private EmployeeNode root;
	/** initialize the resume tree */
	//private ResumeTree tree;
	
	/**
	 * Constructs a new HR manager with the given input files
	 * 
	 * @param pathToEmployeeFile
	 *            - the path to the employee input file
	 * @param pathToResumeFile
	 *            - the path to the resume input file
	 */
	public HumanResourcesManager(String pathToEmployeeFile, String pathToResumeFile) {
	   root = null;
	   //tree = new ResumeTree();
	   try {
		   root = EmployeeReader.readEmployee(pathToEmployeeFile);
		   //tree = ResumeReader.readResume(pathToResumeFile);
	   } catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Cannot find file.");
	   }
	}
	
	/**
	 * Returns a string representation of the interim employee
	 * who replaces the removed employee. If the removed employee
	 * does not supervise any other employees, then remove the
	 * employee and return "No interim supervisor"
	 * 
	 * @param first - the first name of the employee to remove
	 * @param last - the last name of the employee to remove
	 * @return the name of the employee who was promoted to interim supervisor
	 */
	public String removeEmployee(String first, String last)
	{
	    return null;
	}
	
	/**
	 * Returns the string representation of the organizational
	 * profile of the company using the given input employee file.
	 * 
	 * note: this method used 
	 * 		level-order traversal algorithm
	 * 		based on Dr.Jason King in class power point
	 * 
	 * @return the organizational profile
	 */
	public String generateOrganizationalProfile()
	{
		// level-order traversal algorithm, based on Dr.Jason King in class power point
		StringBuilder sb = new StringBuilder();
		sb.append("OrganizationalProfile[\n");
		EmployeeNode temp = root;
		if (root == null) {
			sb.append("   No active employees.\n]");
			return sb.toString();
		}
		ArrayList<EmployeeNode> list = new ArrayList<EmployeeNode>();
		list.add(temp);
		while (!list.isEmpty()) {
			EmployeeNode q = list.removeFirst();
			sb.append("   " + q.getData().getName() + "\n");
			ArrayList<EmployeeNode> children = q.getChildren();
			while (!children.isEmpty()) {
				list.add(children.removeFirst());
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
//	public static void main(String arg[]) {
//		HumanResourcesManager a = new HumanResourcesManager("input/111.txt", "input/111.txt");
//		System.out.println(a.generateOrganizationalProfile());						
//	}
}
