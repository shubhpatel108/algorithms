package math;

import java.math.BigInteger;

public class SegmentTree {
	Node root;
	int[] arr;
	BigInteger normalize = BigInteger.valueOf(95542721);

	public SegmentTree(int[] arr, int n) {
		this.arr = arr;
		build(n);
	}

	public void build(int n) {
		this.root = buildHelper(0, n-1);
	}

	public Node buildHelper(int l, int r) {
		if(l == r) {
			Node temp = new Node();
			temp.value = BigInteger.valueOf((arr[l]));
			temp.start = l;
			temp.end = r;
			return temp;
		}

		Node newNode = new Node();
		newNode.start = l;
		newNode.end = r;
		int mid = l + (r-l)/2;

		newNode.leftChild = buildHelper(l, mid);
		newNode.rightChild = buildHelper(mid+1, r);
		BigInteger temp = newNode.leftChild.value;
		temp = temp.add(newNode.rightChild.value);
		newNode.value = (temp.mod(normalize));
		return newNode;
	}

	public BigInteger query(Node node, int l, int r) {

		if(node == null || l>node.end || r<node.start)
			return BigInteger.valueOf(0);
		
		if(l <= node.start && node.end <= r) {
			return node.value;
		}

		BigInteger left = query(node.leftChild, l,r);
		BigInteger right = query(node.rightChild, l,r);
		left = left.add(right);
		return left.mod(normalize);
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

		BigInteger temp = node.leftChild.value;
		temp = temp.add(node.rightChild.value);
		node.value = (temp.mod(normalize));
	}

	public BigInteger valueUpdate(BigInteger value) {
		BigInteger val = value.modPow(BigInteger.valueOf(3), (normalize));
//		System.out.println(val);
		return val;
	}

	public void traverse(Node node) {
		if(node == null)
			return;
		traverse(node.leftChild);
//		if(node.leftChild == null && node.rightChild==null)
			System.out.println("Node value: "+node.value +" left: "+node.start + " right: "+node.end);
		traverse(node.rightChild);
	}
}
