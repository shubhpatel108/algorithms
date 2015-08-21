package hack101sep;

import java.util.ArrayList;
import java.util.Comparator;

public class Node {
	int degree;
	boolean lighted;
	int index;
	int value;
	ArrayList<Node> adjNodes;
	public Node(int degree, boolean lighted, int value) {
		this.degree = degree;
		this.lighted = lighted;
		this.value = value;
		adjNodes = new ArrayList<Node>();
	}
	
	public void addAdj(Node v) {
		adjNodes.add(v);
		degree++;
	}
	
	public static class NodeCustomCompare implements Comparator<Node>{

		@Override
		public int compare(Node n1, Node n2) {
			if((n1.lighted && n2.lighted) || (!n1.lighted && !n2.lighted)) {
				return n1.degree >= n2.degree ? -1 : 1;
			} else if(n1.lighted) {
				return -1;
			} else {
				return 1;
			}
		}
		
	}
}
