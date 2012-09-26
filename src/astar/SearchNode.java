package astar;

import java.util.ArrayList;

public class SearchNode implements Comparable{  // Implements comparable for sorting
	private static final double ROUNDINGCONSTANT = 1000;
	State state;						// This should contain the state of the problem
	private double f;							// This is the cost of getting to the node
	private double g;							// This is the estimated cost of getting from the node to the goal
	private double h;							// This is the sum of f & g
	private boolean open;						// This is the status (open/closed) of the node
	private boolean solution;					// This indicates if the node is a solution
	private SearchNode parrent;					// This indicates the best known parrent
	private ArrayList<SearchNode> children;		// This is all of the explorableChildren of node
	private ArrayList<SearchNode> possParrent;	// This is all of the possible parrents of the node
	
	public SearchNode(SearchNode parrent, SearchNode goal) {
		this.open = true;			// A fresh node is allways open
		this.g = parrent.g + 1;		// All problemes I will solve have an edge length of 1 so I add 1 to the parrents g
		this.h = calculateH(goal);	// Calculate h for the node
	}
	
	public SearchNode(State goal) {
		this.state = goal;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public SearchNode getParrent() {
		return parrent;
	}

	public void setParrent(SearchNode parrent) {
		this.parrent = parrent;
	}

	public State getState() {
		return state;
	}

	public double getF() {
		return f;
	}

	public double getG() {
		return g;
	}

	public double getH() {
		return h;
	}

	public boolean isSolution() {
		return solution;
	}

	public ArrayList<SearchNode> getChildren() {
		return children;
	}

	public ArrayList<SearchNode> getPossParrent() {
		return possParrent;
	}

	private double calculateH(SearchNode goal) {
		return 1;		// In here the code for the spesific problem you want to solve should be
	}



	@Override
	public int compareTo(Object anotherNode) {
		if (!(anotherNode instanceof SearchNode))
		      throw new ClassCastException("A node was expected.");
		return (int)((this.f - ((SearchNode)anotherNode).f)*ROUNDINGCONSTANT); //multiplying by a rounding constant to get more exact integer sorting
	}
}
