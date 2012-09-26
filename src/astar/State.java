package astar;

import java.util.Collections;

public class State {
	// This class have to be custom made for a spesific problem.
	private static final int PROBLEMSIZE = 9;
	private int[] stateArray = new int[PROBLEMSIZE];
	
	public State(int[] stateArray) {
		this.stateArray = stateArray;
	}
	public State(State parrent, int a, int b) {
		this.stateArray = parrent.getStateArray();
		int temp = stateArray[a];
		stateArray[a] = stateArray[b];
		stateArray[b] = temp;
	}
	
	public int[] getStateArray() {
		return stateArray;
	}
	@Override
	public boolean equals(Object anotherState) {
		for(int i=0;i<PROBLEMSIZE;i++) {										// Check each cell against each other
			if(((State) anotherState).getStateArrayCell(i)!=stateArray[i]) {
				return false;													// Return false when an inequality is found
			}
		}
		return true;															// Return true if the for loop didn't find an inequality 
	}
	public int getStateArrayCell(int cell) {
		return stateArray[cell];
	}
}
