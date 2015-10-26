//C158
package implementation;

public class Shell {
	Node root;
	Node current;
	
	public Shell() {
		this.root = new Node("", null);
		this.current = this.root;
	}
	
	public void cd(String path) {
		String[] tokens = path.split("/");
		
		if(tokens.length == 0) {
			current = root;
			return;
		}

		if(tokens[0].isEmpty()) {
			current = traverse(root, tokens, 1);
		} else {
			current = traverse(current, tokens, 0);
		}
	}

	public Node traverse(Node node, String[] tokens, int index) {
		
		if(index == tokens.length)
			return node;

		if(tokens[index].equals("..")) {
			return traverse(node.parent, tokens, index + 1);
		}

		if(!node.childs.containsKey(tokens[index])) {
			node.childs.put(tokens[index], new Node(tokens[index], node));
		}
		return traverse(node.childs.get(tokens[index]), tokens, index + 1);
	}
	
	public void pwd(Node node) {
		if(node == null)
			return;
		
		pwd(node.parent);
		System.out.print(node.name);
	}
}
