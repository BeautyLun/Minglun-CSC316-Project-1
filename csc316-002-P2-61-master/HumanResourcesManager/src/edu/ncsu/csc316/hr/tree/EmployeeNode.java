/**
 * 
 */
package edu.ncsu.csc316.hr.tree;

import edu.ncsu.csc316.hr.data.Employee;
import edu.ncsu.csc316.hr.util.ArrayList;

/**
 * the EmployeeNode class
 * 
 * Node: the idea of creating array list as the children of the general tree node 
 * 		is originally from Dr. Jason King in-class node
 * 
 * @author Minglun Zhang
 *
 */
public class EmployeeNode {
	
	/** the employee data */
	private Employee data;
	/** the parent of the node */
	private EmployeeNode parent;
	/** the children of the node */
	private ArrayList<EmployeeNode> children;
	
	/**
	 * the constructor of the node
	 * @param data the employee information
	 */
	public EmployeeNode(Employee data) {
		this.data = data;
		this.parent = null;
		this.children = new ArrayList<EmployeeNode>();
	}
	
	/**
	 * return the employee information
	 * @return the employee information
	 */
	public Employee getData() {
		return data;
	}
	
	/**
	 * return the parent
	 * @return the parent
	 */
	public EmployeeNode getParent() {
		return parent;
	}
	
	/**
	 * return the children list
	 * @return the children list
	 */
	public ArrayList<EmployeeNode> getChildren() {
		return children;
	}
	
	/**
	 * add a child to the node
	 * @param child a employee information
	 */
	public void addChild(Employee child) {
		EmployeeNode childNode = new EmployeeNode(child);
		childNode.parent = this;
		children.add(childNode);
	}
	
//	public String removeNode() {
//		if (this.children.isEmpty()) {
//			this.parent.children.remove(this);
//			return "No interim supervisor";
//		}
//		removeHelper(this);
//		return this.data.getName();
//	}
//	
//	private void removeHelper(EmployeeNode current) {
//		
//	}
}
