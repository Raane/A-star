package astar;

import java.util.ArrayList;

public class SearchNode implements Comparable{
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
		this.state = State.OPEN;
	}

	@Override
	public int compareTo(Object anotherNode) {
		if (!(anotherNode instanceof SearchNode))
		      throw new ClassCastException("A node was expected.");
		return (int)(this.f - ((SearchNode)anotherNode).f)*1000; //multiplying by 1000 to get more exact integer sorting
	}
}
