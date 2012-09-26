package astar;

import java.util.ArrayList;
import java.util.Collections;

public class Astar {
	private static final State GOALSTATE = null; 	// This is where the goalstate should be coded in
	private static final State STARTINGSTATE = null; // This is where the startingstate should be coded in

	private SearchNode goal;					// This store the goal
	private SearchNode start;					// This is the startingNode
	private ArrayList<SearchNode> agenda;		// This store the agenda
	private ArrayList<SearchNode> closedNodes;	// This store the closed nodes
	private ArrayList<SearchNode> visitedNodes;	// This store the visited nodes (including the closed one, but not the agenda)
	
	public Astar() {
		// Initiates the variables
		agenda = new ArrayList<SearchNode>();
		goal = new SearchNode(GOALSTATE);
		closedNodes = new ArrayList<SearchNode>();
		visitedNodes = new ArrayList<SearchNode>();
	}
	
	public SearchNode run(SearchNode root) {
		agenda.add(root);						// Adds the root to the agenda as a starting point
		while(agenda.size()!=0) {				// This is the main agenda loop
			Collections.sort(agenda);			// Sorting the agenda
			SearchNode currentNode = agenda.remove(0);		// After sorting we can just look at the best looking candidate
			if(currentNode.getState().equals(GOALSTATE)) {
				return currentNode;								// return the first found solution
			}
			for(SearchNode closedNode:visitedNodes) {
				if(currentNode.equals(closedNode) && !currentNode.equals(closedNode)) {	// Checks if there is another different node with the same state
					closedNode.addPossibleParrents(currentNode.getPossParrent());	// Lets the new identical node bubble up the graph
					currentNode = closedNode;	// Sets the node we are working on to the new better and equal node
					break;	// Exits as there should never be identical states in the nodes allready in the visited nodes
				}
			}
			for(SearchNode child:currentNode.getChildren()) {				
				agenda.add(child);								// This loop adds the children of the current node to the agenda
			}
			if(visitedNodes.containsAll(currentNode.getChildren())) {
				agenda.remove(currentNode);						// If all the children have been visited we will never have to return to the current node in the agenda loop
			}
			if(!currentNode.isVisited()) visitedNodes.add(currentNode);  // TODO remove this, it's not needed
		}
		return null;
	}
}
