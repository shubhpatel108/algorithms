import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Node {
	int value;
	int index;
	int distance;
	boolean visited = false;
	Edge minTreeEdge;

	ArrayList<Edge> adjEdges;

	public Node(int val) {
		value = val;
		adjEdges = new ArrayList<Edge>();
	}
	
	public ArrayList<Node> adjNodes() {
		ArrayList<Node> adjNodes = new ArrayList<Node>();
		for(Edge e: adjEdges) {
			adjNodes.add(e.dest);
		}
		return adjNodes;
	}
	
	public Edge getEdge(Node dest) {
		for(Edge e: adjEdges) {
			if(e.dest == dest)
				return e;
		}
		return null;
	}
	
	public Edge addAdjEdge(Edge e) {
		if(!adjEdges.contains(e)) {
			adjEdges.add(e);
		}
		return e;
	}
	
	public Edge removeAdjEdge(Edge e) {
		if(adjEdges.contains(e)) {
			adjEdges.remove(e);
		}
		return e;
	}
	
	public static class NodeValueCompare implements Comparator<Node>{

		@Override
		public int compare(Node n1, Node n2) {
			if(n1.value < n2.value)
				return -1;
			if(n1.value > n2.value)
				return 1;
			return 0;
		}
		
	}
	
	public static class NodeDistanceCompare implements Comparator<Node>{

		@Override
		public int compare(Node n1, Node n2) {
			if(n1.distance < n2.distance)
				return -1;
			if(n1.distance > n2.distance)
				return 1;
			return 0;
		}
		
	}
	
	public static class NodeReverseIndexCompare implements Comparator<Node>{

		@Override
		public int compare(Node n1, Node n2) {
			if(n1.index > n2.index)
				return -1;
			if(n1.index < n2.index)
				return 1;
			return 0;
		}
		
	}
	
	public void arrange() {
		Collections.sort(this.adjNodes(), new Node.NodeReverseIndexCompare());
	}
}
