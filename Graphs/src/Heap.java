/*
 * Dynamic heap, allowing changes in the values of Nodes
 * 
*/

import java.util.ArrayList;
import java.util.Comparator;

public class Heap {
	ArrayList<Node> heap;
	Comparator<Node> comparator;

	public Heap(Comparator<Node> c) {
		heap = new ArrayList<Node>();
		comparator = c;
	}
	
	public int push(Node node) {
		heap.add(node);
		node.index = heap.size() - 1;
		return pushUp(heap.size() - 1);
	}
	
	public int updateHeap(int index, Node newNode) {
		if(index < 0 || index > heap.size())
			return -1;

		Node oldNode = heap.get(index);
		heap.set(index, newNode);
		
		if(isLessThanOrEqual(oldNode, newNode)) {
			return pushDown(index);
		} else {
			return pushUp(index);
		}
	}
	
	public Node getNode(int index) {
		if(index<0 || index>=heap.size())
			return null;
		return heap.get(index);
	}

	public Node pop() {
		if(heap.size() > 0) {
			swap(0, heap.size() - 1);
			Node n = heap.remove(heap.size()-1);
			pushDown(0);
			return n;
		} else
			return null;
	}

	public int parent(int i) {
		return (i-1)/2;
	}

	public int left(int i) {
		return i*2 + 1;
	}

	public int right(int i) {
		return i*2 + 2;
	}

	public void swap(int i, int j) {
		heap.get(i).index = j;
		heap.get(j).index = i;
		Node temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j,temp);
	}

	public int pushDown(int i) {
		int left = left(i);
		int right = right(i);
		int smallest = i;

		if(left < heap.size() && isGreater(heap.get(smallest), heap.get(left))) {
			smallest = left;
		} 
		if(right < heap.size() && isGreater(heap.get(smallest), heap.get(right))) {
			smallest = right;
		}
		
		if(smallest != i) {
			swap(smallest, i);
			return pushDown(smallest);
		}
		return i;
	}

	public int pushUp(int i) {
		if(i>0 && isLessThanOrEqual(heap.get(i), heap.get(parent(i)))) {
			swap(parent(i), i);
			return pushUp(parent(i));
		}
		return i;
	}

	public boolean isLessThanOrEqual(Node n1, Node n2) {
		return comparator.compare(n1, n2) < 1;
	}

	public boolean isLess(Node n1, Node n2) {
		return comparator.compare(n1, n2) < 0;
	}

	public boolean isGreater(Node n1, Node n2) {
		return comparator.compare(n1, n2) > 0;
	}
	
	public void printHeap() {
		for(Node n: heap) {
			System.out.println(n.value);
		}
	}
}
