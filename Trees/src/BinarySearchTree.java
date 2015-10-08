
public class BinarySearchTree {
	Node root;
	boolean debug = false;
	public BinarySearchTree() {
		root = null;
	}
	
	public Node addNode(Node root, Node node) {
		if(root == null) {
			this.root = node;
			return root;
		}
		
		if(node.data <= root.data) {
			if(root.left == null) {
				root.left = node;
				node.parent = root;
				return node;
			}
			else
				return addNode(root.left, node);
		} else {
			if(root.right == null) {
				root.right = node;
				node.parent = root;
				return node;
			}
			else
				return addNode(root.right, node);
		}
	}
	
	public Node minimum(Node root) {
		if(root == null)
			return null;
		
		if(root.left != null)
			return minimum(root.left);
		
		return root;
	}
	
	public Node maximum(Node root) {
		if(root == null)
			return null;
		
		if(root.right != null)
			return minimum(root.right);
		
		return root;
	}
	
	public void traverse(Node node) {
		if(node == null)
			return;
		
		processNodeEarly(node);
		processNode(node);
		processNodeLate(node);
	}
	
	public void processNodeEarly(Node node) {
		traverse(node.left);
	}
	
	public void processNode(Node node) {
		System.out.println(node.data);

		if(debug && node.left != null)
			System.out.println("Left Child : " + node.left.data);
		
		if(debug && node.right != null)
			System.out.println("Right Child : " + node.right.data);
		
		if(debug)
			System.out.println("=====");
	}
	
	public void processNodeLate(Node node) {
		traverse(node.right);
	}
	
	public int height(Node node) {
		return node == null? -1 : node.height;
	}
}
