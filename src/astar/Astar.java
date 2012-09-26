package astar;

import java.util.ArrayList;
import java.util.Collections;

public class Astar {
	static int[] startingArray = {1,2,3,4,5,6,7,8,9};
	public static final State GOALSTATE = new State(1/2); 	// This is where the goalstate should be coded in
	private static final State STARTINGSTATE = new State(startingArray); // This is where the startingstate should be coded in

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
		start = new SearchNode(STARTINGSTATE);
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
			System.out.println(currentNode.getState());
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
	
	public static void main(String[] args) {
		Astar astar = new Astar();
		SearchNode solution = astar.run(astar.start);
	}
}
