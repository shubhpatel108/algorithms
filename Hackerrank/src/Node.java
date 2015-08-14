import java.util.Comparator;


public class Node {
	int val;
	int index;
	
	public Node(int v, int i) {
		this.val = v;
		this.index = i;
	}
	
	public static class NodeCompare implements Comparator<Node> {

		@Override
		public int compare(Node n1, Node n2) {
			if(n1.val < n2.val)
				return -1;
			if(n2.val < n1.val)
				return 1;
			return 0;
		}
		
	}
}
