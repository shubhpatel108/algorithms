import java.util.ArrayList;
import java.util.HashMap;

//Represented as collection of edges
public class Graph {
	ArrayList<Edge> edges;
	ArrayList<Node> nodes;
	int V;
	int E;
	boolean directional;

	public Graph(boolean directional) {
		edges = new ArrayList<Edge>();
		nodes = new ArrayList<Node>();
		this.directional = directional;
	}

	public void addEdge(Node src, Node dest, int weight) {
		
		if(getNodeIndex(src) == -1) {
			nodes.add(src);
			V++;
		}
		if(getNodeIndex(dest) == -1) {
			nodes.add(dest);
			V++;
		}

		if(directional) {
			Edge e = new Edge(src, dest, weight, directional);
			edges.add(e);
			src.addAdjEdge(e);
		} else {
			Edge e = new Edge(src, dest, weight, directional);
			edges.add(e);
			src.addAdjEdge(e);
			E++;

			e = new Edge(dest, src, weight, directional);
			edges.add(e);
			dest.addAdjEdge(e);
			E++;
		}
	}
	
	public void addEdge(int srcIndex, int destIndex, int weight) {
		Node src = getNode(srcIndex);
		Node dest = getNode(destIndex);

		addEdge(src, dest, weight);
	}

	public Edge removeEdge(Edge e) {
		if(edges.contains(e)) {
			edges.remove(e);
			E--;
			e.src.removeAdjEdge(e);
		}
		return null;
	}
	
	public Node addNode(int val) {
		Node newNode = new Node(val);
		newNode.index = V++;
		newNode.value = newNode.index;
		newNode.distance = Integer.MAX_VALUE;
		newNode.visited = false;
		nodes.add(newNode);
		return newNode;
	}
	
	public Node removeNode(Node node) {
		
		for(Edge edge : node.adjEdges) {
			edges.remove(edge);
		}

		if(nodes.contains(node)) {
			nodes.remove(node);
			V--;
			return node;
		}

		return null;
	}
	
	public Node getNode(int index) {
		if(index < nodes.size()) {
			return nodes.get(index);
		}
		return null;
	}
	
	public int getNodeIndex(Node node) {
		return  nodes.indexOf(node);
	}

	public int numOfEdges() {
		if(this.directional)
			return edges.size();
		else
			return edges.size()/2;
	}

	public int numOfNodes() {
		HashMap<Node, Boolean> map = new HashMap<Node, Boolean>();
		for(Edge e: edges) {
			if(!map.containsKey(e.src)) {
				map.put(e.src, true);
			}
			if(!map.containsKey(e.dest)) {
				map.put(e.dest, true);
			}
		}
		return map.size();
	}

	public void showEdges() {
		for(Edge e: edges) {
//			System.out.println("From "+e.src.value+" to "+e.dest.value + " with weight " + e.weight);
		}
	}
	
	public void initialize(int n) {
		for(int i=0;i<n;i++) {
			addNode(i);
		}
	}
	
}
