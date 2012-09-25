package astar;

import java.util.ArrayList;
import java.util.Collections;

public class Astar {
	ArrayList<SearchNode> agenda;
	//Collections.sort(agenda);
	public Astar() {
		agenda = new ArrayList<SearchNode>();
	}
	
	public void run(SearchNode root) {
		agenda.add(root);
		while(agenda.size()!=0) {
			Collections.sort(agenda);			// Sorting the agenda
			currentNode = agenda.remove(0);		//
			agenda.add(e);
			
		}
	}
}
