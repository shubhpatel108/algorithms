
public class BellmanFordShortestPath {
	public boolean shortestPathToAll(Graph g, Node source) {
		
		initialize(g);
		source.distance = 0;
		
		for(int i=0;i<g.V;i++) {
			for(Edge e : g.edges) {
				relax(e);
			}
		}
		
		for(Edge e: g.edges) {
			if(e.dest.distance > e.src.distance + e.weight) {
				return false;
			}
		}
		return true;
	}
	
	public void relax(Edge e) {
		if(e.src.distance!=Integer.MAX_VALUE && e.dest.distance > e.src.distance + e.weight) {
			e.dest.distance = e.src.distance + e.weight;
		}
	}
	
	public void initialize(Graph g) {
		for(Node n:g.nodes) {
			n.distance = Integer.MAX_VALUE;
		}
	}
}
