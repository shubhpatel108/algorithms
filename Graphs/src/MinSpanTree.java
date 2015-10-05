import java.util.ArrayList;
import java.util.Collections;


public class MinSpanTree {
	int parents[];
	int ranks[];
	public Graph getMinSpanTree(Graph g) {
		ArrayList<Edge> edges = g.edges;
		Collections.sort(edges, (new Edge.EdgeCompare()));

		int n = g.nodes.size();
		
		parents = new int[n];
		
		for(int i=0;i<n;i++)
			parents[i] = -1;
		
		ranks = new int[n];
		int e = 1;
		int i = 0;
		
		Graph minTree = new Graph(false);

		while(e < g.V && i<g.E) {
			Edge edge = edges.get(i);
			if(union(g.getNodeIndex(edge.src), g.getNodeIndex(edge.dest))) {
				e++;
				minTree.addEdge(edge.src, edge.dest, edge.weight);
			}
			i++;
		}
		return minTree;
	}
	
	public boolean union(int i, int j) {
		int x = find(i);
		int y = find(j);
		
		if(x == y)
			return false;

		if(ranks[x] > ranks[y]) {
			parents[y] = x;
		} else if(ranks[x] < ranks[y]){
			parents[x] = y;
		} else {
			parents[y] = x;
			ranks[x]++;
		}
		return true;
	}
	
	public int find(int i) {
		if(parents[i] == -1)
			return i;
		return find(parents[i]);
	}
	
	public int immediateParent(int i) {
		return parents[i];
	}
}
