package RoundB;

import java.util.ArrayList;

public class Node {
	int index;
	ArrayList<Integer> adjNodes;
	int[][] times;
	boolean visited;
	int visitTime;
	public Node(int index, int n) {
		this.index = index;
		visited = false;
		times = new int[n][24];
		adjNodes = new ArrayList<Integer>();
		visitTime = Integer.MAX_VALUE;
	}
	
	public void addAdjNode(int v) {
		adjNodes.add(v);
	}
	
	public void setTimes(int[] arr, int v) {
		this.times[v] = arr;
	}
	
	public void printAdj() {
		for(int i=0;i<adjNodes.size();i++) {
			System.out.println(adjNodes.get(i));
		}
	}
}
