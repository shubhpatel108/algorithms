package SegmentTree;

public class Tree {
	Node root;

	public Tree(String value) {
		build(value);
	}

	public void build(String value) {
		int n = value.length();
		this.root = buildHelper(value, 0, n-1);
	}

	public Node buildHelper(String value, int l, int r) {
		if(l == r) {
			Node temp = new Node(value.substring(l,r+1));
			temp.start = l;
			temp.end = r;
			return temp;
		}

		Node newNode = new Node(value.substring(l,r+1));
		newNode.start = l;
		newNode.end = r;
		int mid = l + (r-l)/2;

		newNode.leftChild = buildHelper(value, l, mid);
		newNode.rightChild = buildHelper(value, mid+1, r);
		
		return newNode;
	}

	public String query(Node node, int l, int r) {

		if(node == null || l>node.end || r<node.start)
			return "";
		
		if(l <= node.start && node.end <= r) {
			return node.value;
		}

		String left = query(node.leftChild, l,r);
		String right = query(node.rightChild, l,r);
		return left + right;
	}
	
	public void update(Node node, int l, int r) {
		if(node == null)
			return;

		if(l > node.end || r < node.start)
			return;

		if(node.start == node.end) {
			node.value = valueUpdate(node.value);
			return;
		}

		update(node.leftChild, l, r);
		update(node.rightChild, l, r);
		node.value = node.leftChild.value + node.rightChild.value;
	}

	public String valueUpdate(String value) {
		StringBuilder buffer = new StringBuilder(value);
		for(int i=0;i<value.length();i++) {
			if(buffer.charAt(i)=='0')
				buffer.setCharAt(i, '1');
		}
		return buffer.toString();
	}
	
	public void traverse(Node node) {
		if(node == null)
			return;
		traverse(node.leftChild);
		System.out.println("Node value: "+node.value +" left: "+node.start + " right: "+node.end);
		traverse(node.rightChild);
	}
}
