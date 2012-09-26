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
		this.stateArray = stateArray;
		int temp = stateArray[a];
		stateArray[a] = stateArray[b];
		stateArray[b] = temp;
	}
	
	@Override
	public boolean equals(Object anotherState) {
		boolean equal = true;
		for(int i=0;i<PROBLEMSIZE;i++) {
			if(((State) anotherState).getStateArrayCell(i)==stateArray[i])
		}
		return equal;		// This should return if the state is the same 
	}
	private int getStateArrayCell(int cell) {
		// TODO Auto-generated method stub
		return stateArray[cell];
	}
}
