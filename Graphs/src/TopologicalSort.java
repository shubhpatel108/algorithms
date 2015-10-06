import java.util.ArrayList;
import java.util.List;


public class TopologicalSort {
	public List<Node> sort(Graph g) {
		List<Node> list = new ArrayList<Node>();
		for(Node n : g.nodes) {
			list.addAll(0, DepthFirstTraversal(n, 0));
		}
		return list;
	}
	
	public List<Node> DepthFirstTraversal(Node node, int depth) {
		List<Node> list = new ArrayList<Node>();
		if(!node.visited) {
			node.visited = true;

			for(Node adjNode : node.adjNodes()) {
				list.addAll(0, DepthFirstTraversal(adjNode, depth+1));
			}
			list.add(0, node);
		}
		return list;
	}
	
	public List<Node> DepthFirstTraversal(Node node, int depth, boolean[] cities) {
		List<Node> list = new ArrayList<Node>();
		if(!node.visited) {
			node.visited = true;

			for(Node adjNode : node.adjNodes()) {
				list.addAll(0, DepthFirstTraversal(adjNode, depth+1));
			}
			if(cities[node.index])
				list.add(0, node);
		}
		return list;
	}

}
