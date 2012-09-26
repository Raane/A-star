package astar;

import java.util.ArrayList;
import java.util.Collections;

public class Astar {
	ArrayList<SearchNode> agenda;
	SearchNode goal;
	public Astar() {
		agenda = new ArrayList<SearchNode>();
		goal = new SearchNode(State goalState);
	}
	
	public void run(SearchNode root) {
		agenda.add(root);
		while(agenda.size()!=0) {
			Collections.sort(agenda);			// Sorting the agenda
			SearchNode currentNode = agenda.remove(0);		//
			if(currentNode.getState().equals(goal.getState()));
			agenda.
		}
	}
}
