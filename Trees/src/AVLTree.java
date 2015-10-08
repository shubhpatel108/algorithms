
public class AVLTree extends BinarySearchTree {

	public void insert(int data) {
		Node newNode = new Node(data);
		this.root = insert(this.root, newNode);
	}
	
	public Node insert(Node root, Node node) {
		if(root == null) {
			root = node;
		} else if(node.data < root.data) {
			root.left = insert(root.left, node);
			
			if(balance(root) == -2) {
				if(node.data < root.left.data) {
					root = rightRotate(root);
				} else {
					root = leftRightRotate(root);
				}
			}
		} else if(node.data > root.data) {
			root.right = insert(root.right, node);
			
			if(balance(root) == 2) {
				if(node.data > root.right.data) {
					root = leftRotate(root);
				} else {
					root = rightLeftRotate(root);
				}
			}
		}
		
		updateHeight(root);

		return root;
	}
	
	public int updateHeight(Node node) {
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		return node.height;
	}
	
	public int balance(Node node) {
		return (height(node.right) - height(node.left));
	}
	
	public Node rightRotate(Node node) {
		if(node == null)
			return null;

		Node leftChild = node.left;
		
		if(leftChild == null)
			return node;

		Node leftRightChild = node.left.right;
		
		node.left = leftRightChild;
		if(leftRightChild != null)
			leftRightChild.parent = node;
		
		leftChild.parent = node.parent;
		node.parent = leftChild;
		leftChild.right = node;
		
		updateHeight(node);
		updateHeight(leftChild);
		
		return leftChild;
	}
	
	public Node leftRotate(Node node) {
		if(node == null)
			return null;

		Node rightChild = node.right;
		
		if(rightChild == null)
			return node;

		Node rightLeftChild = node.right.left;
		
		node.right = rightLeftChild;
		if(rightLeftChild != null)
			rightLeftChild.parent = node;
		
		rightChild.parent = node.parent;
		node.parent = rightChild;
		rightChild.left = node;

		updateHeight(node);
		updateHeight(rightChild);

		return rightChild;
	}
	
	public Node rightLeftRotate(Node node) {
		node.right = rightRotate(node.right);
		return leftRotate(node);
	}

	public Node leftRightRotate(Node node) {
		node.left = leftRotate(node.left);
		return rightRotate(node);
	}
}
