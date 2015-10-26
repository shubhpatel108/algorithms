//C158
package implementation;

import java.util.HashMap;

public class Node {
	String name;
	HashMap<String, Node> childs;
	Node parent;
	
	public Node(String name, Node parent) {
		this.name = name + "/";
		childs = new HashMap<String, Node>();
		this.parent = parent;
	}
}
