package SEPT15;

import java.util.Comparator;

public class Node {
	int x;
	int y;
	int val;
	
	public Node(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}
	
	public static class NodeCompare implements Comparator<Node> {

		@Override
		public int compare(Node n1, Node n2) {
			if(n1.val < n2.val)
					return -1;
			if(n1.val > n2.val)
					return 1;
			return 0;
		}
		
	}
}
