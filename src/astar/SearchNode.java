package astar;

import java.util.ArrayList;

public class SearchNode {
	State state;
	double f;
	double g;
	double h;
	boolean status;
	boolean solution;
	SearchNode parrent;
	ArrayList<SearchNode> children;
	ArrayList<SearchNode> possParrent;
	
	public SearchNode() {
		// TODO Auto-generated constructor stub
	}
}
