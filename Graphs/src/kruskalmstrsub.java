import java.util.Collections;

// https://www.hackerrank.com/challenges/kruskalmstrsub
public class kruskalmstrsub {
	public SimpleEdge[] minTree(EdgeGraph g, int V) {
		Collections.sort(g.edges, new SimpleEdge.EdgeCustomCompare1());
		SimpleEdge[] edges = new SimpleEdge[V-1];
		boolean included[] = new boolean[V];
		
		int includedEdges = 0;
		
		for(SimpleEdge e : g.edges) {
			if(includedEdges==V)
				break;
			if(!included[e.uNode] && !included[e.uNode]) {
				edges[includedEdges] = e;
				included[e.uNode] = true;
				included[e.vNode] = true;
				includedEdges++;
			}
		}
		return edges;
	}
}
