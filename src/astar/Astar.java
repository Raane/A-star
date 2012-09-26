package astar;

import java.util.ArrayList;
import java.util.Collections;

public class Astar {
	private static final State GOALSTATE = null; // This is where the goalstate should be coded in

	private SearchNode goal;
	private ArrayList<SearchNode> agenda;
	private ArrayList<SearchNode> closedNodes;
	private ArrayList<SearchNode> visitedNodes;
	
	public Astar() {
		agenda = new ArrayList<SearchNode>();
		goal = new SearchNode(GOALSTATE);
		closedNodes = new ArrayList<SearchNode>();
		visitedNodes = new ArrayList<SearchNode>();
	}
	
	public SearchNode run(SearchNode root) {
		agenda.add(root);
		while(agenda.size()!=0) {
			Collections.sort(agenda);			// Sorting the agenda
			SearchNode currentNode = agenda.remove(0);		//
			if(currentNode.getState().equals(goal.getState())) {
				return currentNode;
			}
			for(SearchNode closedNode:visitedNodes) {
				if(currentNode.equals(closedNode) && !currentNode.equals(closedNode)) {	// Checks if there is another different node with the same state
					closedNode.updateG(currentNode.getG());	// Lets the new identical node bubble up the graph
					currentNode = closedNode;	// Sets the node we are working on to the new better and equal node
					break;	// Exits as there should never be identical states in the nodes allready in the visited nodes
				}
			}
			for(SearchNode child:currentNode.getChildren()) {				
				agenda.add(child);
			}
			if(closedNodes.containsAll(currentNode.getChildren())) {
				agenda.remove(currentNode);
			}
			visitedNodes.add(currentNode);
		}
		return null;
	}
}
