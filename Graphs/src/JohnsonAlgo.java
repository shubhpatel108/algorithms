//Wrong. Cannot figure out the problem.
public class JohnsonAlgo {
	public int[][] allShortestPaths(Graph g) {
		Node newNode = g.addNode(g.V);

		for(Node n : g.nodes)
			g.addEdge(newNode, n, 0);
		
		BellmanFordShortestPath bfsp = new BellmanFordShortestPath();
		bfsp.shortestPathToAll(g, newNode);

		g.removeNode(newNode);

		for(Edge e : g.edges) {
			e.weight = e.weight + e.src.distance - e.dest.distance;
		}

		int[][] dist = new int[g.V][g.V];
		
		for(int i=0;i<g.V;i++) {
			Node n = g.nodes.get(i);

			DijkstraShortestPath dsp = new DijkstraShortestPath();
			dsp.shortestPathsToAll(g, n);
			
			for(int j=0;j<g.V;j++) {
//				System.out.println("Distance :" + j + " from " + n.value + " is: "+g.nodes.get(j).distance);
				dist[i][j] = g.nodes.get(j).distance;
			}
		}
		
		print(dist);
		return dist;
	}
	
	public void print(int[][] arr) {
		int n = arr.length;
		if(n<0)
			return;
		int m = arr[0].length;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++)
				System.out.print(String.format("%11d", arr[i][j]));
			System.out.println();
		}
	}
}
