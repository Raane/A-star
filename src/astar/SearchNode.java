package astar;

import java.util.ArrayList;

public class SearchNode implements Comparable{  // Implements comparable for sorting
	private static final double ROUNDINGCONSTANT = 1000;
	private static final double STEPCOST = 1;
	State state;						// This should contain the state of the problem
	private double f;							// This is the cost of getting to the node
	private double g;							// This is the estimated cost of getting from the node to the goal
	private double h = -1;							// This is the sum of f & g
	private boolean open;						// This is the status (open/closed) of the node
	private boolean visited;
	private boolean solution;					// This indicates if the node is a solution
	private SearchNode parrent;					// This indicates the best known parrent
	private ArrayList<SearchNode> children;		// This is all of the explorableChildren of node
	private ArrayList<SearchNode> possParrent;	// This is all of the possible parrents of the node
	
	public SearchNode(SearchNode parrent, State goalState) {
		this.open = true;			// A fresh node is allways open
		this.g = parrent.g + 1;		// the cost to get to a node is more the cost of the edge from the parrent plus the cost to get to the parrent
		this.h = calculateH(goalState);	// Calculate h for the node
		this.visited = false;
	}
	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
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
		return getG() + getH();
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

	public void addPossibleParrents(ArrayList<SearchNode> possParrent) {
		this.possParrent.addAll(possParrent);
		SearchNode bestParrent = possParrent.get(0);
		for(int i=0;i<possParrent.size();i++) {					// Finds the best parrent amongst the new parrents
			if(possParrent.get(i).getG()>bestParrent.getG()) {
				bestParrent = possParrent.get(i);
			}
		}
		updateParrent(parrent);									// Updates the best parrent
	}
	
	private double calculateH(State goalstate) {
		return 1;		// In here the code for the spesific problem you want to solve should be
	}

	

	@Override
	public int compareTo(Object anotherNode) {	// This makes the list sortable
		if (!(anotherNode instanceof SearchNode))
		      throw new ClassCastException("A node was expected.");
		return (int)((this.f - ((SearchNode)anotherNode).f)*ROUNDINGCONSTANT); //multiplying by a rounding constant to get more exact integer sorting
	}

	private boolean updateParrent(SearchNode Parrent) {
		// If the g is higher than the new g we update the g and all it's childrens g 	
		if(this.g>Parrent.getG()) {								
			this.g=Parrent.getG();
			if(children!=null) { // This is in case the children have not been calculated
				for(SearchNode child:children) {
					child.updateParrent(this);
				}
			}
			return true;
		}
		return false;
	}

	private double getStepCost() {
		return STEPCOST;	// In the problems i'm solving I will only need constant stepcost, this could however be altered.
	}
}
