
public class Node {
	int data;
	Node left;
	Node right;
	Node parent;
	int height;
	
	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
		parent = null;
		height = 0;
	}
}
