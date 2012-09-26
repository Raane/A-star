package astar;

import java.util.ArrayList;
import java.util.Collections;

public class Astar {
	ArrayList<SearchNode> agenda;
	SearchNode goal;
	ArrayList<SearchNode> closedNodes;
	public Astar() {
		agenda = new ArrayList<SearchNode>();
		goal = new SearchNode(State goalState);
		closedNodes = new ArrayList<SearchNode>();
	}
	
	public SearchNode run(SearchNode root) {
		agenda.add(root);
		while(agenda.size()!=0) {
			Collections.sort(agenda);			// Sorting the agenda
			SearchNode currentNode = agenda.remove(0);		//
			if(currentNode.getState().equals(goal.getState())) {
				return currentNode;
			}
			for(SearchNode closedNode:closedNodes) {
				if(currentNode.equals(closedNode)) {
					closedNode.updateG(currentNode.getG());
					currentNode = closedNode;
					break;
				}
			}
			for(SearchNode child:currentNode.getChildren()) {				
				agenda.add(child);
			}
		}
		return null;
	}
}
