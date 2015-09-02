package C321_580;

import java.util.ArrayList;

public class Node {
	ArrayList<Node> children;
	int index;
	boolean hasCats;
	boolean visited;

	public Node(int index, boolean hasCats) {
		this.index = index;
		this.hasCats = hasCats;
		children = new ArrayList<Node>();
		visited = false;
	}

	public void addNode(Node node) {
		children.add(node);
	}
}
